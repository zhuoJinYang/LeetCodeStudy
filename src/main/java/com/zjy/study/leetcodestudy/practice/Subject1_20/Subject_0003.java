package com.zjy.study.leetcodestudy.practice.Subject1_20;

/**
 * @Author zjy
 * @Date 2023/2/3 13:17
 * @Description
 *      无重复字符的最长子串
 */
public class Subject_0003 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    private static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0;i < 128;i++){
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start,last[index] + 1);
            res = Math.max(res,i - start + 1);
            last[index] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int nums = lengthOfLongestSubstring(s);
        System.out.println(nums);
    }

    /**
     * 感想：
     *      先利用一个集合来记录每个字符出现的index下标位置,并在每次遍历结束前重新记录一下出现位置
     *      遍历时比较字符出现的下标位置和(未出现重复的)初始位置来判断初始位置有没有重置
     *      最后比较保存的最大(未出现重复的)字符长度和目前计算的最大长度来返回最大长度
     *      目标就是要有这样的思维逻辑能力！
     */
}
