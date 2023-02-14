package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zjy
 * @Date 2023/2/14 13:11
 * @Description
 *      ReentrantLock 案例
 */
public class T_ReentrantLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"C").start();
    }

    private static class Ticket{
        private int num = 30;
        Lock lock = new ReentrantLock();
        private void sale(){
            lock.lock();
            try{
                if (num > 0){
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + (num--) + "张票，剩余" + num + "张票");
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
