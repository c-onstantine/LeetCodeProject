package com.liming.zijie;


/**
 * @author ltf
 * @date 2021-10-11 20:14
 * 92. 反转链表 II
 */
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        ListNode pre = dummyhead;
        ListNode cur = head;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode remove = cur.next;
            cur.next = cur.next.next;
            remove.next = pre.next;
            pre.next = remove;
            pre = remove;
        }
        return dummyhead.next;
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
