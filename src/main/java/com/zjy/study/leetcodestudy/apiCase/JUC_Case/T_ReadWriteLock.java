package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author zjy
 * @Date 2023/2/16 11:17
 * @Description
 *      读写锁：
 * 一个资源可以被多个读线程访问，或者被一个写线程访问，但是不能同时存在读写线程，读写互斥，读读是共享的
 *          写锁：独占锁
 *          读锁：共享锁
 */
public class T_ReadWriteLock {
    /*
    加了读写锁,写锁是独占锁,读锁是共享锁,
    因此写的过程不允许任何操作,当写操作写完之后,可以多个线程共享读
     */
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            // 写入
            new Thread(() -> {
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            //读取
            new Thread(() -> {
                System.out.println("获取" + temp + "缓存数据-> " + myCache.get(temp + ""));
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 自定义缓存
     */
    static class MyCache{
        private volatile Map<String,Object> map = new HashMap<>();
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        /**
         * 存 写
         */
        public void put(String key,Object value){
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
                map.put(key, value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readWriteLock.writeLock().unlock();
            }
            System.out.println(Thread.currentThread().getName() + "写入OK");
        }

        /**
         * 取 读
         */
        public Object get(String key){
            readWriteLock.readLock().lock();
            Object o = null;
            try {
                System.out.println(Thread.currentThread().getName() + "读取" + key);
                o = map.get(key);
                System.out.println(Thread.currentThread().getName() + "读取OK");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readWriteLock.readLock().unlock();
            }
            return o;
        }
    }
}
