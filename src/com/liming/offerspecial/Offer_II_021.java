package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-14 20:03
 */
public class Offer_II_021 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = new ListNode();
        slow.next = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
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
