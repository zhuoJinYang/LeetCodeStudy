package com.zjy.study.leetcodestudy.practice.Subject41_60;

/**
 * @Author zjy
 * @Date 2023/2/24 9:26
 * @Description
 *      字符串相乘
 */
public class Subject_0043 {
    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     *
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     *
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     */
    private static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        String ans = "0";
        int m = num1.length();
        int n = num2.length();
        for (int i = n-1; i >= 0 ; i--) {
            StringBuilder curr = new StringBuilder();
            int add = 0;
            for (int j = n - 1; j > i ; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m-1; j >= 0 ; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0){
                curr.append(add % 10);
            }
            ans = addStrings(ans,curr.reverse().toString());
        }
        return ans;
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
