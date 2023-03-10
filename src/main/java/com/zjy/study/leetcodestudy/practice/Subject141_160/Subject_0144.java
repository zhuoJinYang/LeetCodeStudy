package com.zjy.study.leetcodestudy.practice.Subject141_160;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zjy
 * @Date 2023/3/10 10:18
 * @Description
 *      二叉树的前序遍历
 */
public class Subject_0144 {
    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     * 
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     * 
     * 示例 4：
     * 输入：root = [1,2]
     * 输出：[1,2]
     * 
     * 示例 5：
     * 输入：root = [1,null,2]
     * 输出：[1,2]
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

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }

    private static void preOrder(TreeNode root,List<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2));
        System.out.println(preorderTraversal(root));
    }
}
