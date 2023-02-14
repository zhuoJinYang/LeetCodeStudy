package com.zjy.study.leetcodestudy.practice.Subject1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/2/14 9:32
 * @Description
 *      四数之和
 */
public class Subject_0018 {
    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
     * [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     *
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     *
     * 示例 1：
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     *
     * 示例 2：
     * 输入：nums = [2,2,2,2,2], target = 8
     * 输出：[[2,2,2,2]]
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums,4,0,target);
    }

    private static List<List<Integer>> nSum(int[] nums,int n,int start,int target){
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n < 2 || size < n){
            return result;
        }
        if (n == 2){
            int left = start;
            int right = size - 1;
            while (left < right) {
                int leftElem = nums[left];
                int rightElem = nums[right];
                int sum = leftElem + rightElem;
                if (sum < target) {
                    //左指针右移+去重
                    while (left < right && nums[left] == leftElem) {
                        left++;
                    }
                } else if (sum > target) {
                    //右指针左移+去重
                    while (left < right && nums[right] == rightElem) {
                        right--;
                    }
                } else {
                    //加入一组元素
                    result.add(Arrays.asList(leftElem, rightElem));
                    //去重
                    while (left < right && nums[left] == leftElem) {
                        left++;
                    }
                    while (left < right && nums[right] == rightElem) {
                        right--;
                    }
                }
            }
        } else {
            for (int i = start; i < size; i++) {
                List<List<Integer>> lists = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list: lists){
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.addAll(list);
                    result.add(arrayList);
                }
                //去重
                while (i < size - 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
    /**
     * 感想：
     *      有个nc案例超出int范围了,排除掉就行 - - ！
     */
}
