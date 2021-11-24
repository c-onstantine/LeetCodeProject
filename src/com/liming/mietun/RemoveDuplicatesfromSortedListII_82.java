package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-10-21 10:49
 * 82. 删除排序链表中的重复元素 II
 */
public class RemoveDuplicatesfromSortedListII_82 {
    //public ListNode deleteDuplicates(ListNode head) {
    //    ListNode dummy = new ListNode();
    //    dummy.next = head;
    //    ListNode pre = dummy;
    //    ListNode cur = head;
    //    while (cur != null) {
    //        while (cur.next != null && cur.val == cur.next.val) {
    //            cur = cur.next;
    //        }
    //        if (pre.next == cur) {
    //            pre = pre.next;
    //        } else {
    //            pre.next = cur.next;
    //        }
    //        cur = cur.next;
    //    }
    //    return dummy.next;
    //}


    // 递归写法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            ListNode move = head.next;
            while (move != null && head.val == move.val) {
                move = move.next;
            }
            return deleteDuplicates(move);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
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
