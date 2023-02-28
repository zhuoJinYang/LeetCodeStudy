package com.zjy.study.leetcodestudy.practice.Subject101_120;

import com.zjy.study.leetcodestudy.practice.Subject81_100.Subject_0100;

/**
 * @Author zjy
 * @Date 2023/2/28 10:49
 * @Description
 *      对称二叉树
 */
public class Subject_0101 {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     *
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
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

    private static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,new TreeNode(3),new TreeNode(4)),
                new TreeNode(2,new TreeNode(4),new TreeNode(3)));
        System.out.println(isSymmetric(root));
    }
}
