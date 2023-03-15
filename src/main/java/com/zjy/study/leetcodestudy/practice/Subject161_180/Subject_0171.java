package com.zjy.study.leetcodestudy.practice.Subject161_180;

/**
 * @Author zjy
 * @Date 2023/3/15 8:46
 * @Description
 *      Excel 表列序号
 */
public class Subject_0171 {
    /**
     * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
     *
     * 例如：
     *
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28 
     * ...
     *  
     *
     * 示例 1:
     * 输入: columnTitle = "A"
     * 输出: 1
     *
     * 示例 2:
     * 输入: columnTitle = "AB"
     * 输出: 28
     *
     * 示例 3:
     * 输入: columnTitle = "ZY"
     * 输出: 701
     */
    private static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res = 0;
        for (int i = 0; i <= chars.length - 1; i++) {
            res = res * 26 + chars[i] - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
