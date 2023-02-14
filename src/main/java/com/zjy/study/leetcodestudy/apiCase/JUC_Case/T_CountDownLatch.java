package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zjy
 * @Date 2023/2/14 14:28
 * @Description
 *      计数器
 */
public class T_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "--->Go out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("Close Door!");
    }
}
