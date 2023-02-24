package com.zjy.study.leetcodestudy.practice.Subject61_80;

/**
 * @Author zjy
 * @Date 2023/2/24 14:35
 * @Description
 *      爬楼梯
 */
public class Subject_0070 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     *
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     *
     * 示例 2：
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */
    private static int climbStairs(int n) {
        if (n<=2){
            return n;
        }
        int a=1,b=2,temp;
        for (int i = 3; i <= n; i++) {
            temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(climbStairs(n));
    }
}
