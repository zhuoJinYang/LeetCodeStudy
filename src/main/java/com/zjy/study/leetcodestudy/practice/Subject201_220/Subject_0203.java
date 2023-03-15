package com.zjy.study.leetcodestudy.practice.Subject201_220;

import com.zjy.study.leetcodestudy.practice.Subject141_160.Subject_0144;

/**
 * @Author zjy
 * @Date 2023/3/15 10:40
 * @Description
 *      移除链表元素
 */
public class Subject_0203 {
    /**
     * 给你一个链表的头节点 head 和一个整数 val ，
     * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *
     * 示例 1：
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     * 
     * 示例 2：
     * 输入：head = [], val = 1
     * 输出：[]
     * 
     * 示例 3：
     * 输入：head = [7,7,7,7], val = 7
     * 输出：[]
     */
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next :head;
    }

    public static void main(String[] args) {

    }
}
