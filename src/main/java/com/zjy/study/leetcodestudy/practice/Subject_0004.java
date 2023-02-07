package com.zjy.study.leetcodestudy.practice;

/**
 * @Author zjy
 * @Date 2023/2/3 14:23
 * @Description
 *      寻找两个正序数组的中位数
 */
public class Subject_0004 {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     *
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *
     * 示例 2：
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     */
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1)/2;
        int right = (m + n + 2)/2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    //i: nums1的起始位置 j: nums2的起始位置
    private static int findKth(int[] nums1,int i,int[] nums2,int j,int k){
        if (i >= nums1.length){
            return nums2[j+k-1];
        }
        if (j >= nums2.length){
            return nums1[i+k-1];
        }
        if (k == 1){
            return Math.min(nums1[i],nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2){
            return findKth(nums1,i + k / 2,nums2,j,k - k/2);
        }else {
            return findKth(nums1,i,nums2,j + k / 2,k - k/2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
    /**
     * 感想：
     *      绕死了,想了很久才懂了个大致，回溯+对分,查找两个数组的中位数并比较,
     *      若出现差异,再进行回溯和对分查，直至超出条件或两数组只剩一个元素
     *      最后来判断这两个数组的中位数，很强
     */
}
