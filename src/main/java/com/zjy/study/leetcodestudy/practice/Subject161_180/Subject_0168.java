package com.zjy.study.leetcodestudy.practice.Subject161_180;

/**
 * @Author zjy
 * @Date 2023/3/14 9:47
 * @Description
 *      Excel表列名称
 */
public class Subject_0168 {
    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
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
     * 示例 1：
     * 输入：columnNumber = 1
     * 输出："A"
     *
     * 示例 2：
     * 输入：columnNumber = 28
     * 输出："AB"
     *
     * 示例 3：
     * 输入：columnNumber = 701
     * 输出："ZY"
     *
     * 示例 4：
     * 输入：columnNumber = 2147483647
     * 输出："FXSHRXW"
     */
    private static String convertToTitle(int columnNumber) {
        if (columnNumber <= 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0){
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
