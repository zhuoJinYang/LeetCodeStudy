package com.zjy.study.leetcodestudy.practice.Subject21_40;

/**
 * @Author zjy
 * @Date 2023/2/17 15:53
 * @Description
 *      找出字符串中第一个匹配项的下标
 */
public class Subject_0028 {
    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
     * 如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     * 示例 1：
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     *
     * 示例 2：
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     */
    private static int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();

        int i=0,j=0;
        while(i<haystack.length()){
            if(hay[i] == nee[j]){
                i++;
                j++;
            }else if(j>0){
                j = next[j-1];
            }else{
                i++;
            }
            if(j==needle.length()){
                return i-j;
            }
        }
        return -1;
    }

    /*
    获得next数组
     */
    private static int[]  getNext(String needle){
        int[] next = new int[needle.length()];
        char[] chars = needle.toCharArray();
        int j = 0;
        for(int i=1;i<needle.length();i++){
            while(j>0 && chars[i] != chars[j]){
                j = next[j-1];
            }
            if(chars[i] == chars[j]){
                next[i] = ++j;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String haystack = "sasbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }
}
