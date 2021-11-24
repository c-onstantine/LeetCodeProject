package com.liming.offeragain;


/**
 * @author ltf
 * @date 2021-11-06 21:34
 * 剑指 Offer 24. 反转链表
 */
public class Offer_24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
