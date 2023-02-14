package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author zjy
 * @Date 2023/2/14 14:16
 * @Description
 */
public class T_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new MyRThread()).start();
        /*
        本身Callable接口和Runnable接口毫无关系
        通过一个Runnable接口的实现类FutureTask,Callable接口与Runnable接口构建了关系,便可以启动线程
         */

        // 适配类 FutureTask 是 Runnable 接口的实现类 构造器 FutureTask(Callable<V> callable)
        MyCThread t1 = new MyCThread();
        FutureTask<Integer> futureTask = new FutureTask<>(t1);
        /*
        启动两个线程,只会打印一个call()...
         */
        new Thread(futureTask,"A").start(); // 怎么启动Callable
        new Thread(futureTask, "B").start();  // 结果被缓存,效率高
        //获取线程返回值 get()可能会产生阻塞！把他放到最后 或者 使用异步通信来处理！
        Integer integer = futureTask.get();
        System.out.println(integer);
    }

    private static class MyRThread implements Runnable {
        @Override
        public void run() {

        }
    }

    private static class MyCThread implements Callable<Integer> {
        @Override
        public Integer call() {
            System.out.println("call()...");
            // 耗时的操作
            return 1024;
        }
    }
    // 注意
    // 1.有缓存
    // 2.获取结果可能需要等待,会阻塞
}
