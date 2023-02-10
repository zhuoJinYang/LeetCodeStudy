package com.zjy.study.leetcodestudy.apiCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author zjy
 * @Date 2023/2/9 14:12
 * @Description
 *      CompletableFuture 案例
 */
public class T_CompletableFuture {
    public static void main(String[] args) {
        List<Long> ids = new ArrayList<Long>();
        for (int i = 1; i <= 500; i++) {
            ids.add((long) i);
        }
        List<CompletableFuture<?>> futures = new ArrayList<>();
        List<List<Long>> partitionIdList = splitList(ids, 9);
        System.out.println("partitionIdList -> " + partitionIdList);
        partitionIdList.forEach(partitionIds -> {
            List<String> strList = new ArrayList<>();
            // 自定义一个线程池
            ForkJoinPool pool = new ForkJoinPool();
            CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
                partitionIds.forEach(id -> {
                    strList.add(id.toString());
                });
                return strList;
            },pool);
            futures.add(future);
        });

        List<String> strResultList = new ArrayList<>();
        for (CompletableFuture<?> future : futures){
            try {
                strResultList.addAll((List<String>)future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(strResultList);
    }

    public static <T> List<List<T>> splitList(List<T> list, int len){
        if (list.size() == 0){
            return Collections.emptyList();
        }

        List<List<T>> result = new ArrayList<>();
        int size = list.size();
        int count = (size + len - 1) / len;
        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, (Math.min((i + 1) * len, size)));
            result.add(subList);
        }
        return result;
    }
}
