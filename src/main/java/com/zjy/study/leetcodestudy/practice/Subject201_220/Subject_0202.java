package com.zjy.study.leetcodestudy.practice.Subject201_220;

import java.util.HashSet;

/**
 * @Author zjy
 * @Date 2023/3/15 10:26
 * @Description
 *      快乐数
 */
public class Subject_0202 {
    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」 定义为：
     *
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     *
     * 示例 1：
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 1(2) + 9(2) = 82
     * 8(2) + 2(2) = 68
     * 6(2) + 8(2) = 100
     * 1(2) + 0(2) + 0(2) = 1
     * 
     * 示例 2：
     * 输入：n = 2
     * 输出：false
     */
    private static boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner){
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    private static int getNext(int num){
        int totalSum = 0;
        while (num > 0){
            int d = num % 10;;
            num = num / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
