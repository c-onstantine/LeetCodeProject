package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-10-19 19:47
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        while (k > 0) {
            k--;
            fast = fast.next;
        }
        while (fast != null) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
