package com.zjy.study.leetcodestudy.practice.Subject21_40;

import lombok.ToString;

/**
 * @Author zjy
 * @Date 2023/2/16 10:10
 * @Description
 *      两两交换链表中的节点
 */
public class Subject_0024 {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     *
     * 示例 2：
     * 输入：head = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：head = [1]
     * 输出：[1]
     */
    @ToString
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4))));
        System.out.println(swapPairs(listNode));
    }
}
