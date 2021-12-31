package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-31 10:57
 * 剑指 Offer II 077. 链表排序
 * 归并排序
 */
public class Offer_II_077 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode head1 = head;
        ListNode head2 = split(head);

        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1, head2);
    }

    private ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        return half;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
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
