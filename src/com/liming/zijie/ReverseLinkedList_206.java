package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-09-23 20:57
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        ListNode tmp = null;
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
