package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

/**
 * @Author zjy
 * @Date 2023/2/14 13:24
 * @Description
 *      wait notify 模拟生产者和消费者问题
 */
public class T_wait_notify {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }

    private static class Data{
        private int num = 0;

        private synchronized void increment() throws InterruptedException {
            // while 代替 if,防止出现线程虚假唤醒的情况
            while (num != 0) {
                // 等待
                this.wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + " => " + num);
            // 通知其他线程+1完毕
            this.notifyAll();
        }

        private synchronized void decrement() throws InterruptedException {
            while (num == 0){
                this.wait();
            }
            num --;
            System.out.println(Thread.currentThread().getName() + " => " + num);
            this.notifyAll();
        }
    }
}
