package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author zjy
 * @Date 2023/2/16 13:09
 * @Description
 *      阻塞队列
 *          使用场景：多线程并发处理，线程池
 */
public class T_BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        addAndRemove();
        offerAndPoll();
        offerAndPollWaitingTime();
        putAndTake();
    }

    // 抛出异常
    private static void addAndRemove(){
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));

        //java.lang.IllegalStateException: Queue full 抛出异常
        //System.out.println(arrayBlockingQueue.add("d"));

        System.out.println("*****************");
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());

        //java.util.NoSuchElementException 抛出异常
        //System.out.println(arrayBlockingQueue.remove());
    }

    // 有返回值,不抛出异常
    private static void offerAndPoll(){
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        //System.out.println(arrayBlockingQueue.offer("d"));    // false,不抛出异常

        System.out.println("*****************");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());  // null 不抛出异常
    }

    // 等待,阻塞(等待超时)
    private static void offerAndPollWaitingTime() throws InterruptedException {
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        System.out.println(arrayBlockingQueue.offer("d",2, TimeUnit.SECONDS));  //等待两秒，超时退出

        System.out.println("*****************");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        arrayBlockingQueue.poll(2, TimeUnit.SECONDS); //等待两秒，超时退出
    }

    // 等待,阻塞(一直阻塞)
    private static void putAndTake() throws InterruptedException {
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        //arrayBlockingQueue.put("d");  //队列没有位置了，一直阻塞

        System.out.println("*****************");
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());  //没有数据了，一直阻塞
    }
}
