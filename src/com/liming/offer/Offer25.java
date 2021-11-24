package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-03 16:58
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode reshead = null;
        if (l1.val <= l2.val) {
            reshead = l1;
            reshead.next = mergeTwoLists(l1.next, l2);
        } else {
            reshead = l2;
            reshead.next = mergeTwoLists(l1, l2.next);
        }
        return reshead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
