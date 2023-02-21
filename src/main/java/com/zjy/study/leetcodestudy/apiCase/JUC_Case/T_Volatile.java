package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zjy
 * @Date 2023/2/21 14:33
 * @Description
 */
public class T_Volatile {
    // 如果不加volatile程序会死循环
    // 加了volatile是可以保证可见性的,volatile保证一旦数据被修改,其他线程立马能够感知到
    private volatile static AtomicInteger num = new AtomicInteger(0);
    private static void add(){
        num.getAndIncrement();
    }
    public static void main(String[] args) {
        // 可见性案例
        /*new Thread(() -> {
            while (num == 0){

            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        System.out.println(num);*/

        // 不保证原子性案例
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        // main gc
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);

        // 禁止指令重排序 无案例,自行想象
        /*
         volatile中会加一道内存的屏障，这个内存屏障可以保证在这个屏障中的指令顺序。
         内存屏障：CPU指令。作用：
            1、保证特定的操作的执行顺序；
            2、可以保证某些变量的内存可见性（利用这些特性，就可以保证volatile实现的可见性）
         */
    }
}
