package com.zjy.study.leetcodestudy.apiCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/2/10 15:24
 * @Description
 */
public class T_Demo {
    public static void main(String[] args) {
        List<Long> ids = new ArrayList<Long>();
        for (int i = 1; i <= 500; i++) {
            ids.add((long) i);
        }
        List<List<Long>> partitionIdList = splitList(ids, 9);
        partitionIdList.forEach(partitionIds -> {
            System.out.println("partitionIds -> " + partitionIds);
        });
    }

    private static <T> List<List<T>> splitList(List<T> list, int num){
        if (list.size() == 0){
            return Collections.emptyList();
        }
        List<List<T>> result = new ArrayList<>();
        int size = list.size();
        int count = (size + num - 1) / num;
        for (int i = 0; i < num; i++) {
            List<T> subList = list.subList(i * count, (Math.min((i + 1) * count, size)));
            result.add(subList);
        }
        return result;
    }
}
