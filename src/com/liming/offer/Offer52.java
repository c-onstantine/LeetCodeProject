package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-23 17:23
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena = getlen(headA), lenb = getlen(headB);
        int tmp = lena - lenb;
        ListNode llist = headA;
        ListNode slist = headB;
        if (tmp < 0) {
            llist = headB;
            slist = headA;
            tmp = -tmp;
        }
        for (int i = 0; i < tmp; i++) {
            llist = llist.next;
        }
        while (llist != null && slist != null && llist != slist) {
            llist = llist.next;
            slist = slist.next;
        }
        return llist;

    }

    private int getlen(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
