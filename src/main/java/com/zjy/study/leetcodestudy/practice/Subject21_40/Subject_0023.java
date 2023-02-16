package com.zjy.study.leetcodestudy.practice.Subject21_40;

import lombok.ToString;

import java.util.*;

/**
 * @Author zjy
 * @Date 2023/2/16 9:31
 * @Description
 *      合并K个升序链表
 */
public class Subject_0023 {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     *
     * 示例 2：
     * 输入：lists = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：lists = [[]]
     * 输出：[]
     */
    @ToString
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists){
            if (list == null){
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()){
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null){
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        // [1,4,5],[1,3,4],[2,6]
//        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
//        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));
//        ListNode listNode3 = new ListNode(2,new ListNode(6));
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(0);
        ListNode[] list = new ListNode[3];
        list[0] = listNode1;
        list[1] = listNode2;
        System.out.println(mergeKLists(list));
    }
}

