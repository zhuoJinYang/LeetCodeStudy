package com.zjy.study.leetcodestudy.practice.Subject21_40;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/2/16 9:17
 * @Description
 *      括号生成
 */
public class Subject_0022 {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     *
     * 示例 2：
     * 输入：n = 1
     * 输出：["()"]
     */
    static List<String> res = new ArrayList<>();
    private static List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }

    private static void dfs(int left, int right, String curStr){
        if (left == 0 && right == 0){
            res.add(curStr);
            return;
        }
        if (left > 0){
            dfs(left - 1,right,curStr + "(");
        }
        if (right > left){
            dfs(left,right - 1,curStr + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
