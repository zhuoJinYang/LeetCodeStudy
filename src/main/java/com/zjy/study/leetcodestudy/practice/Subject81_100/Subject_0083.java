package com.zjy.study.leetcodestudy.practice.Subject81_100;

import lombok.ToString;

/**
 * @Author zjy
 * @Date 2023/2/24 15:24
 * @Description
 *      删除排序链表中的重复元素
 */
public class Subject_0083 {
    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     *
     * 示例 1：
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     *
     * 示例 2：
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     */
    @ToString
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val){
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(3)))));
        System.out.println(deleteDuplicates(listNode));
    }
}
