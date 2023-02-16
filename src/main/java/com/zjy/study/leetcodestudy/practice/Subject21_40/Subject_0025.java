package com.zjy.study.leetcodestudy.practice.Subject21_40;

import lombok.ToString;

import java.util.List;

/**
 * @Author zjy
 * @Date 2023/2/16 10:28
 * @Description
 *      K 个一组翻转链表
 */
public class Subject_0025 {
    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 
     * 示例 2：
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     */
    @ToString
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;
        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null){
            check = check.next;
            canProceed ++;
        }
        // 满足条件,进行翻转
        if (canProceed == k){
            while (count < k && cur != null){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count ++;
            }
            if (next != null){
                // head 为链表翻转后的尾节点
                head.next = reverseKGroup(next,k);
            }
            // prev 为链表翻转后的头节点
            return prev;
        } else {
            // 不满足翻转条件,直接返回
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5)))));
        System.out.println(reverseKGroup(listNode, 2));
    }
}
