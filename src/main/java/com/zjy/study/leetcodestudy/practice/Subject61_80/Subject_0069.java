package com.zjy.study.leetcodestudy.practice.Subject61_80;

/**
 * @Author zjy
 * @Date 2023/2/24 14:23
 * @Description
 *      x 的平方根
 */
public class Subject_0069 {
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     *
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     *
     * 示例 2：
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */
    private static int mySqrt(int x) {
        if (x == 1){
            return 1;
        }
        int min = 0;
        int max = x;
        while(max-min>1){
            int m = (max+min)/2;
            if (x/m<m){
                max = m;
            } else {
                min = m;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }
}
