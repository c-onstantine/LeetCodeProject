package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-03 16:06
 */
public class Offer24 {
/*    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pnode = head;
        ListNode ppre = null;
        ListNode nhead = null;
        while (pnode != null) {
            ListNode pnext = pnode.next;
            if (pnext == null) nhead = pnode;
            pnode.next = ppre;
            ppre = pnode;
            pnode = pnext;
        }
        return nhead;
    }*/

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
