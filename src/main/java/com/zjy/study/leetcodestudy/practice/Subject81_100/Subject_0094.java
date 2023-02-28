package com.zjy.study.leetcodestudy.practice.Subject81_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author zjy
 * @Date 2023/2/28 10:24
 * @Description
 *      二叉树的中序遍历
 */
public class Subject_0094 {
    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     *
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
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

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(inorderTraversal(root));
    }
}
