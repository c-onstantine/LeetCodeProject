package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-09-29 20:05
 * 143. 重排链表 从中间分开 然后后一段逆序 之后 在交替拼接
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newhead = slow.next;
        slow.next = null;
        newhead = reverselistnode(newhead);
        while (newhead != null) {
            ListNode tmp = newhead.next;
            newhead.next = head.next;
            head.next = newhead;
            head = newhead.next;
            newhead = tmp;
        }
    }

    private ListNode reverselistnode(ListNode head) {
        ListNode pre = null, cur = head, tmp = null;
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
