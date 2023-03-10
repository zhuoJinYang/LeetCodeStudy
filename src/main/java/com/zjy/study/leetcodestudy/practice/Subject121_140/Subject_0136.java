package com.zjy.study.leetcodestudy.practice.Subject121_140;

import java.util.*;

/**
 * @Author zjy
 * @Date 2023/3/10 9:10
 * @Description
 *      只出现一次的数字
 */
public class Subject_0136 {
    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，
     * 其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     *
     * 示例 1 ：
     * 输入：nums = [2,2,1]
     * 输出：1
     *
     * 示例 2 ：
     * 输入：nums = [4,1,2,1,2]
     * 输出：4
     *
     * 示例 3 ：
     * 输入：nums = [1]
     * 输出：1
     */
    private static int singleNumber(int[] nums) {
//        return Arrays.stream(nums).reduce((a,b) -> a^b).getAsInt();
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
