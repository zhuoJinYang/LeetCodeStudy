package com.zjy.study.leetcodestudy.practice.Subject141_160;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/3/10 10:33
 * @Description
 *      二叉树的后序遍历
 */
public class Subject_0145 {
    /**
     * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     *
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[3,2,1]
     * 
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        afterOrder(root,res);
        return res;
    }

    private static void afterOrder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        afterOrder(root.left,res);
        afterOrder(root.right,res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3),null));
        System.out.println(postorderTraversal(root));
    }
}
