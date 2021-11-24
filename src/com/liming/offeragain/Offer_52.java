package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-16 19:45
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class Offer_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA, n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
