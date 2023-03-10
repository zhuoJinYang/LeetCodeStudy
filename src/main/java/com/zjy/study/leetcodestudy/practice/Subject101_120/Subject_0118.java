package com.zjy.study.leetcodestudy.practice.Subject101_120;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/3/1 13:06
 * @Description
 *      杨辉三角
 */
public class Subject_0118 {
    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     *
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * 示例 1:
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     *
     * 示例 2:
     * 输入: numRows = 1
     * 输出: [[1]]
     */
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    row.add(1);
                    continue;
                }
                row.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
