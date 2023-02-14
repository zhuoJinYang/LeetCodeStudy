package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author zjy
 * @Date 2023/2/14 13:52
 * @Description
 */
public class T_JUC_List {
    //java.util.ConcurrentModificationException 并发修改异常！
    public static void main(String[] args) {
        // 并发下 ArrayList 不安全
        /**
         * 解决方案
         * 1. List<String> list = new Vector<>()
         * 2. List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3. List<String> list = new CopyOnWriteArrayList<>();
         */
        //CopyOnWrite 写入时复制 COW 计算机程序设计领域的一种优化策略
        // 多个线程操作的时候 list 读取的时候 固定的 写入(覆盖)
        // 再写入的时候避免覆盖,造成数据问题
        // 读写分利
        // CopyOnWriteArrayList 比 Vector 好在哪里？
        // Vector 底层是synchronized实现效率较低;
        // CopyOnWriteArrayList底层是ReentrantLock实现,效率更高,灵活性更高
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
