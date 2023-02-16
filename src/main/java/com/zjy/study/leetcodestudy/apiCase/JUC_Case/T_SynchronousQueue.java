package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author zjy
 * @Date 2023/2/16 13:21
 * @Description
 *      同步队列
 *          进去一个元素,必须等待取出来后,才能再往里面放入元素
 */
public class T_SynchronousQueue {
    /*
    SynchronousQueue 和 BlockingQueue 不一样，SynchronousQueue 不存储元素
    put一个元素，必须从里面take取出来，否则不能再put进去值！（存一个，取一个，循环）
     */
    public static void main(String[] args) {
        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "->put 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "->put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "->put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "->take " + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "->take " + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "->take " + synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"T2").start();
    }
}
