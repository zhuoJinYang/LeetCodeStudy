package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author zjy
 * @Date 2023/2/14 14:32
 * @Description
 */
public class T_CyclicBarrier {
    public static void main(String[] args) {
        /*
        集齐7颗龙珠召唤神龙
         */
        // 召唤神龙的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("成功召唤神龙！"));
        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集了" + temp + "颗龙珠");
                try {
                    cyclicBarrier.await();// 等待
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
