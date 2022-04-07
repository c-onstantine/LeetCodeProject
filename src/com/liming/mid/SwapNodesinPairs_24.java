package com.liming.mid;

/**
 * @author ltf
 * @date 2022-04-07 17:38
 */
public class SwapNodesinPairs_24 {
    //非递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode tmp = pre;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }
        return pre.next;
    }


    // 递归写法
    //public ListNode swapPairs(ListNode head) {
    //    if (head == null || head.next == null) return head;
    //    ListNode next = head.next;
    //    head.next = swapPairs(next.next);
    //    next.next = head;
    //    return next;
    //}

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
