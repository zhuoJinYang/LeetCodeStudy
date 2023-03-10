package com.zjy.study.leetcodestudy.practice.Subject101_120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/3/10 8:54
 * @Description
 *      杨辉三角 II
 */
public class Subject_0119 {
    /**
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     *
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * 示例 1:
     * 输入: rowIndex = 3
     * 输出: [1,3,3,1]
     * 
     * 示例 2:
     * 输入: rowIndex = 0
     * 输出: [1]
     * 
     * 示例 3:
     * 输入: rowIndex = 1
     * 输出: [1,1]
     */
    private static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0){
            return Collections.singletonList(1);
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> preRow = getRow(rowIndex - 1);
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == rowIndex){
                res.add(1);
                continue;
            }
            res.add(preRow.get(i - 1) + preRow.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
