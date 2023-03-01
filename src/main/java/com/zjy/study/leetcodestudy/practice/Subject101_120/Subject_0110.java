package com.zjy.study.leetcodestudy.practice.Subject101_120;

/**
 * @Author zjy
 * @Date 2023/3/1 10:13
 * @Description
 *      平衡二叉树
 */
public class Subject_0110 {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：true
     * 
     * 示例 2：
     * 输入：root = [1,2,2,3,3,null,null,4,4]
     * 输出：false
     * 
     * 示例 3：
     * 输入：root = []
     * 输出：true
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

    private static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private static int height(TreeNode root) {
        if (root == null){
            return 0;
        } else {
            return Math.max(height(root.left),height(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                new TreeNode(4)),
                        new TreeNode(3)),
                new TreeNode(2));
        System.out.println(isBalanced(root));
    }
}
