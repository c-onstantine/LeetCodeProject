package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-10-26 19:30
 */
public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode fast = pre, slow = pre;
        while (n >= 0) {
            n--;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
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
