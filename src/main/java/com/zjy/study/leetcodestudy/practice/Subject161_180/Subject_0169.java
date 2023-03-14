package com.zjy.study.leetcodestudy.practice.Subject161_180;

import java.util.Arrays;

/**
 * @Author zjy
 * @Date 2023/3/14 9:55
 * @Description
 *      多数元素
 */
public class Subject_0169 {
    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
     * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 示例 1：
     * 输入：nums = [3,2,3]
     * 输出：3
     *
     * 示例 2：
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     */
    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
