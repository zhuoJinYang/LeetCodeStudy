package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.concurrent.*;

/**
 * @Author zjy
 * @Date 2023/2/16 13:41
 * @Description
 */
public class T_ThreadPool {
    /*
    Executors 工具类：创建线程池  3大方法
     */
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//创建单个线程的线程池
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建固定线程的线程池
        //ExecutorService threadPool = Executors.newCachedThreadPool();//创建可伸缩线程池

        // 获取CPU核数 电脑处理器数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //手动创建线程池 ThreadPoolExecutor
        //最大线程到底如何定义？
        //1、CPU 密集型  电脑处理器数是几，就是几，可以保证CPU的效率最高！
        //2、IO 密集型   大于 程序中十分耗IO的线程数   ---> 程序中 15个大型任务 io十分占用资源！ =》 30

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,  //核心线程池大小
                Runtime.getRuntime().availableProcessors(),  //最大核心线程池大小
                3,  //超时了没有人调用就会释放
                TimeUnit.SECONDS,   //超时单位
                new LinkedBlockingQueue<>(3),   //阻塞队列
                Executors.defaultThreadFactory(),   //线程工厂：创建线程，一般不用动
                new ThreadPoolExecutor.DiscardOldestPolicy() //拒绝策略 队列满了，尝试和最早的竞争，也不会抛出异常！
        );

        // 四种拒绝策略
        /*
        * new ThreadPoolExecutor.AbortPolicy() //默认拒绝策略 银行满了，还有人进来，不处理这个人，抛出异常
        * new ThreadPoolExecutor.CallerRunsPolicy() //哪来的去哪里！
        * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务，不会抛出异常
        * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试和最早的竞争，也不会抛出异常！
         */

        try {
            for (int i = 0; i < 10; i++) {
                //使用了线程池之后，用线程池来创建线程
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }

    /*
    7大参数
    public static ExecutorService newSingleThreadExecutor() {
    return new FinalizableDelegatedExecutorService
        (new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>()));
    }

    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }

	//本质：ThreadPoolExecutor()
    public ThreadPoolExecutor(int corePoolSize, //核心线程池大小
                              int maximumPoolSize, //最大核心线程池大小
                              long keepAliveTime, //超时了没有人调用就会释放
                              TimeUnit unit, //超时单位
                              BlockingQueue<Runnable> workQueue, //阻塞队列
                              ThreadFactory threadFactory, //线程工厂：创建线程，一般不用动
                              RejectedExecutionHandler handler) { //拒绝策略
        if (corePoolSize < 0 ||
            maximumPoolSize <= 0 ||
            maximumPoolSize < corePoolSize ||
            keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.acc = System.getSecurityManager() == null ?
                null :
                AccessController.getContext();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }
     */
}
