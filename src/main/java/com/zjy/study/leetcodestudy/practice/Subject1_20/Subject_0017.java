package com.zjy.study.leetcodestudy.practice.Subject1_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/2/14 9:11
 * @Description
 *      电话号码的字母组合
 */
public class Subject_0017 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * 示例 2：
     * 输入：digits = ""
     * 输出：[]
     *
     * 示例 3：
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     */
    static List<String> list = new ArrayList<>();
    static StringBuilder temp = new StringBuilder();
    private static List<String> letterCombinations(String digits) {
        String[] digStr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if (digits == null || digits.length() == 0){
            return list;
        }
        backTracking(digits,digStr,0);
        return list;
    }

    private static void backTracking(String digits, String[] digStr, int num){
        if (num == digits.length()){
            list.add(temp.toString());
            return;
        }
        String str = digStr[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, digStr, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
    /**
     * 感想：
     *      回溯,牢记！
     */
}
