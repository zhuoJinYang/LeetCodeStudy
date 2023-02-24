package com.zjy.study.leetcodestudy.practice.Subject61_80;

/**
 * @Author zjy
 * @Date 2023/2/24 11:12
 * @Description
 *      二进制求和
 */
public class Subject_0067 {
    /**
     * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     *
     * 示例 1：
     * 输入:a = "11", b = "1"
     * 输出："100"
     *
     * 示例 2：
     * 输入：a = "1010", b = "1011"
     * 输出："10101"
     */
    private static String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int n = a.length() - 1;
        int m = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int add = 0;
        while (n >= 0 || m >= 0 || add != 0){
            int numA = n >= 0 ?charsA[n] - '0':0;
            int numB = m >= 0 ?charsB[m] - '0':0;
            if (numA + numB + add >= 2){
                res.append((numA + numB + add) % 2);
                add = (numA + numB + add) / 2;
            } else {
                res.append(numA + numB + add);
                add = 0;
            }
            n--;
            m--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}
