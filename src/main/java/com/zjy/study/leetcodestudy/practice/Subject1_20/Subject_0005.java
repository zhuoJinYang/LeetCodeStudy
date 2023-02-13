package com.zjy.study.leetcodestudy.practice.Subject1_20;

/**
 * @Author zjy
 * @Date 2023/2/7 14:21
 * @Description
 *      最长回文子串
 */
public class Subject_0005 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     */
    private static String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        //保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //把回文看成中间的部分全是同一字符，左右部分相对称
            //找到下一个与当前字符不同的字符
            i = findLongest(str,i,range);
        }
        return s.substring(range[0],range[1] + 1);
    }

    private static int findLongest(char[] str, int low, int[] range) {
        //查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        //定位中间部分的最后一个字符
        int ans = high;
        //从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        //记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public static void main(String[] args) {
        String longestPalindrome = longestPalindrome("babad");
        System.out.println(longestPalindrome);
    }
    /**
     * 感想：
     *      很好的思维，遍历并通过拓展来判断回文，用range保存长度，慢慢提升！！！
     */
}
