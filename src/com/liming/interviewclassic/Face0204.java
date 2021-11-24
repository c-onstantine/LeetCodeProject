package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-04-21 20:54
 */
public class Face0204 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallhead = small;
        ListNode large = new ListNode(0);
        ListNode largehead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largehead.next;
        return smallhead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
