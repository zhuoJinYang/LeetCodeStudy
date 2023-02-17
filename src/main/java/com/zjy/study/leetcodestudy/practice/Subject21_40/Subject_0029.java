package com.zjy.study.leetcodestudy.practice.Subject21_40;

/**
 * @Author zjy
 * @Date 2023/2/17 16:30
 * @Description
 *      两数相除
 */
public class Subject_0029 {
    /**
     * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
     * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
     * 返回被除数 dividend 除以除数 divisor 得到的 商 。
     *
     * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2(31),  2(31) − 1] 。本题中，如果商 严格大于 2(31) − 1 ，则返回 2(31) − 1 ；
     * 如果商 严格小于 -2(31) ，则返回 -2(31) 。
     *
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
     *
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
     */
    private static int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) < 0;    //用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((t>>i)>=d){
                result+=1<<i;
                t-=d<<i;
            }
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(divide(dividend, divisor));
    }
}
