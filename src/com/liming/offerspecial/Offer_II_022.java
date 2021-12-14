package com.liming.offerspecial;


/**
 * @author ltf
 * @date 2021-12-14 20:57
 */
public class Offer_II_022 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null; //无环
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break; //相遇
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        //再次相遇 就是入口点
        return fast;
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
