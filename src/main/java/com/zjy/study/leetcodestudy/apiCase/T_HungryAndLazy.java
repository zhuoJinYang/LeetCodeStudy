package com.zjy.study.leetcodestudy.apiCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author zjy
 * @Date 2023/2/21 14:58
 * @Description
 *      饿汉式和懒汉式
 */
public class T_HungryAndLazy {
    // 饿汉式 核心思想:构造器私有化
    // 可能浪费内存空间
    /*private byte[] data = new byte[1024 * 1024];

    private static final T_HungryAndLazy HUNGRY = new T_HungryAndLazy();
    private T_HungryAndLazy(){};

    public static T_HungryAndLazy getInstance(){
        return HUNGRY;
    }*/

    // 懒汉式
    private volatile static T_HungryAndLazy lazyMan;
    private static boolean flag = false;
    private T_HungryAndLazy(){
        synchronized (T_HungryAndLazy.class){
            if (!flag){
                flag = true;
            } else {
                throw new RuntimeException("不要试图使用反射破坏异常！");
            }
        }
    }
    //双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static T_HungryAndLazy getInstance(){
        if (null == lazyMan){
            synchronized (T_HungryAndLazy.class){
                if (null == lazyMan){
                    lazyMan = new T_HungryAndLazy();
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                T_HungryAndLazy.getInstance();
//            }).start();
//        }

        // 反射
        Field flag = T_HungryAndLazy.class.getDeclaredField("flag");
        flag.setAccessible(true);

        Constructor<T_HungryAndLazy> constructor = T_HungryAndLazy.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);

        T_HungryAndLazy instance = constructor.newInstance();
        flag.set(instance, false);

        T_HungryAndLazy instance1 = constructor.newInstance();
        System.out.println(instance == instance1);
    }
}
