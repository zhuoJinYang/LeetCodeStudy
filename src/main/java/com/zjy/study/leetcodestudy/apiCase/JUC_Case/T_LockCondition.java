package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zjy
 * @Date 2023/2/14 13:30
 * @Description
 *      Condition精准的通知和唤醒线程
 */
public class T_LockCondition {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        },"C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        },"D").start();
    }

    private static class Data{
        private int num = 0;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        private void increment() {
            lock.lock();
            try {
                // while 代替 if,防止出现线程虚假唤醒的情况
                while (num != 0) {
                    // 等待
                    condition.await();
                }
                num++;
                System.out.println(Thread.currentThread().getName() + " => " + num);
                // 通知其他线程+1完毕
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private void decrement() {
            lock.lock();
            try {
                // while 代替 if,防止出现线程虚假唤醒的情况
                while (num == 0) {
                    // 等待
                    condition.await();
                }
                num--;
                System.out.println(Thread.currentThread().getName() + " => " + num);
                // 通知其他线程+1完毕
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
