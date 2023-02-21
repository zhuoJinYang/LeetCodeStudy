package com.zjy.study.leetcodestudy.practice.Subject21_40;

import java.util.*;

/**
 * @Author zjy
 * @Date 2023/2/20 8:30
 * @Description
 *      串联所有单词的子串
 */
public class Subject_0030 {
    /**
     * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
     *
     *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
     *
     * 例如，如果 words = ["ab","cd","ef"]，
     * 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。
     * "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
     * 返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。
     *
     * 示例 1：
     * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
     * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
     * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
     * 输出顺序无关紧要。返回 [9,0] 也是可以的。
     *
     * 示例 2：
     * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     * 输出：[]
     * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
     * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
     * 所以我们返回一个空数组。
     *
     * 示例 3：
     * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     * 输出：[6,9,12]
     * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
     * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
     * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
     * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
     */
    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // 所有单词的个数
        int num = words.length;
        // 每个单词的长度(是相同的)
        int wordLen = words[0].length();
        // 字符串长度
        int stringLen = s.length();
        for (int i = 0; i < wordLen; i++) {
            // 遍历的长度超过了整个字符串的长度,退出循环
            if (i + num * wordLen > stringLen){
                break;
            }
            // differ表示窗口中的单词频次和words中的单词频次之差
            Map<String,Integer> differ = new HashMap<>();
            // 初始化窗口,窗口长度为num * wordLen,依次计算窗口里每个切分的单词的频次
            for (int j = 0; j < num; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                differ.put(word,differ.getOrDefault(word,0)+1);
            }
            // 遍历words中的word,对窗口里每个单词计算差值
            for (String word : words){
                differ.put(word,differ.getOrDefault(word,0)-1);
                // 差值为0,移除这个word
                if (differ.get(word) == 0){
                    differ.remove(word);
                }
            }
            // 开始滑动窗口
            for (int start = i; start < stringLen - num * wordLen + 1; start +=wordLen) {
                if (start != i){
                    // 右边的单词滑进来
                    String word = s.substring(start + (num - 1) * wordLen,start + num * wordLen);
                    differ.put(word,differ.getOrDefault(word,0)+1);
                    if (differ.get(word) == 0){
                        differ.remove(word);
                    }
                    // 左边的单词滑出去
                    word = s.substring(start - wordLen, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - wordLen, start);
                }
                // 窗口匹配的单词数等于words中对应的单词数
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        System.out.println(findSubstring(s, words));
    }
}
