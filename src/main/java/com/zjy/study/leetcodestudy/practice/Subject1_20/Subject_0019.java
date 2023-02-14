package com.zjy.study.leetcodestudy.practice.Subject1_20;

import lombok.ToString;

/**
 * @Author zjy
 * @Date 2023/2/14 10:10
 * @Description
 *      删除链表的倒数第 N 个结点
 */
public class Subject_0019 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     * 
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNode(head, n) == n ? head.next : head;
    }

    private static int removeNode(ListNode node, int n){
        if (node.next == null){
            return 1;
        }
        int m = removeNode(node.next,n);
        if (m == n){
            if (m == 1) {
                node.next = null;
            } else {
                node.next = node.next.next;
            }
        }
        return m + 1;
    }

    @ToString
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(listNode, 2));
    }
    /**
     * 感想：
     *      我头晕辣！
     *      removeNode()函数判断节点长度,若节点长度和n一样,则取头结点下一个
     */
}
