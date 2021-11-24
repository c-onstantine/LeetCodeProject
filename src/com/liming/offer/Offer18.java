package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-01 16:53
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = head;
        ListNode pre = p;
        if (head.val == val) {
            if (head.next == null) {
                return null;
            } else {
                return head.next;
            }
        }
        while (p != null && p.val != val) {
            pre = p;
            p = p.next;
        }
        pre.next = p.next;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
