package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-10-19 19:26
 * 141. 环形链表
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
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
