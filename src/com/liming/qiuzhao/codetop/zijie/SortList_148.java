package com.liming.qiuzhao.codetop.zijie;

/**
 * @author ltf
 * @date 2022-07-27 19:34
 * 148. 排序链表
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(second);
        ListNode mid = new ListNode();
        ListNode tmp = mid;
        while (left != null && right != null) {
            if (left.val > right.val) {
                tmp.next = right;
                right = right.next;
            } else {
                tmp.next = left;
                left = left.next;
            }
            tmp = tmp.next;
        }
        tmp.next = left == null ? right : left;
        return mid.next;
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
