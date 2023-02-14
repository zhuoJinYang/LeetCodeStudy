package com.zjy.study.leetcodestudy.apiCase.JUC_Case;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author zjy
 * @Date 2023/2/14 14:02
 * @Description
 */
public class T_JUC_Set {
    //java.util.ConcurrentModificationException 并发修改异常！
    public static void main(String[] args) {
        // HashSet<String> set = new HashSet<>():
        // 解决方案一：
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        // 解决方案二：
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
    /**
     * HashSet底层就是HashMap
     * set 本质就是 map 中的 key,key是不可重复的
     */
}
