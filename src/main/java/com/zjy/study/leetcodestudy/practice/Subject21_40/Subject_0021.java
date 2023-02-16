package com.zjy.study.leetcodestudy.practice.Subject21_40;

import lombok.ToString;

/**
 * @Author zjy
 * @Date 2023/2/16 9:04
 * @Description
 *      合并两个有序链表
 */
public class Subject_0021 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     *
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     */
    @ToString
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode current = listNode;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        if (list1 == null){
            current.next = list2;
        } else {
            current.next = list1;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        System.out.println(mergeTwoLists(listNode1,listNode2));
    }
}
