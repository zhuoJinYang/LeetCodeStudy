package com.zjy.study.leetcodestudy.practice.Subject41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/2/27 13:24
 * @Description
 *      全排列 II
 */
public class Subject_0047 {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     *
     * 示例 2：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    private static boolean[] vis;
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,res,0,perm);
        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, int idx, List<Integer> perm){
        if (idx == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])){
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, res, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
}
