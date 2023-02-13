package com.zjy.study.leetcodestudy.practice.Subject1_20;

/**
 * @Author zjy
 * @Date 2023/2/13 10:19
 * @Description
 *      最长公共前缀
 */
public class Subject_0014 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *  
     *
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length  == 0){
            return "";
        }
        String s = strs[0];
        for (String str : strs){
            while(!str.startsWith(s)){
                s = s.substring(0,s.length() - 1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
    /**
     * 感想：
     *      好思路！
     */
}
