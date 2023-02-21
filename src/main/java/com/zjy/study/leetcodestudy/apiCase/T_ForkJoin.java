package com.zjy.study.leetcodestudy.apiCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @Author zjy
 * @Date 2023/2/21 13:21
 * @Description
 *      ForkJoin 特点： 工作窃取！
 *      实现原理：双端队列！
 */
public class T_ForkJoin {
    /**
     * 求和计算的任务
     *
     * 如何使用 ForkJoin?
     * 1.ForkJoinPool 通过它来执行
     * 2.计算任务 forkJoinPool.execute(ForkJoinTask<?> task)
     * 3.计算类要继承ForkJoinTask
     */
    static class ForkJoinDemo extends RecursiveTask<Long> {
        private Long start;
        private Long end;
        // 临界值
        private Long temp = 10000L;
        public ForkJoinDemo(Long start,Long end){
            this.start = start;
            this.end = end;
        }

        // 计算方法
        @Override
        protected Long compute() {
            if ((end - start) < temp){
                long sum = 0L;
                for (Long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            } else {
                // 分支合并计算
                Long middle = (start + end) / 2;// 中间值
                ForkJoinDemo task1 = new ForkJoinDemo(start,middle);
                task1.fork();// 拆分任务,把线程任务压入线程队列
                ForkJoinDemo task2 = new ForkJoinDemo(middle,end);
                task2.fork();// 拆分任务,把线程任务压入线程队列
                // 结果汇总
                return task1.join() + task2.join();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();    //341
//        test2();    //4704
        test3();    //251
    }

    // 普通程序员
    public static void test1(){
        long sum = 0L;
        long start = System.currentTimeMillis();
        for (long i = 0L; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum = "+sum+" 时间："+(end - start));
    }

    // 会使用forkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L,10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//提交任务
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum = "+sum+" 时间："+(end - start));
    }

    public static void test3(){
        long start = System.currentTimeMillis();
        //Stream 并行流计算 []
        long sum = LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum = "+sum+" 时间："+(end - start));
    }
}
