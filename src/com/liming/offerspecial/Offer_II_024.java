package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-14 21:17
 */
public class Offer_II_024 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, pre = null, tmp = null;
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

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
