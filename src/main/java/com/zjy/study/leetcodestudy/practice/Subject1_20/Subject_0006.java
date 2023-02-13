package com.zjy.study.leetcodestudy.practice.Subject1_20;

/**
 * @Author zjy
 * @Date 2023/2/7 14:47
 * @Description
 *       N 字形变换
 */
public class Subject_0006 {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     * 示例 1：
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 
     * 示例 3：
     * 输入：s = "A", numRows = 1
     * 输出："A"
     */
    private static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            int i = row;
            int step = row;
            while (i < len){
                sb.append(s.charAt(i));
                do {
                    step = numRows - 1 - step;
                } while (step == 0);
                i += 2 * step;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring);
    }
    /**
     * 感想：
     *     好像掌握了规则之后感觉并不是特别难的问题，
     *     每次步长增长都为 step =  rowNum - (rowNum - 1),之后反复赋值即可
     */
}
