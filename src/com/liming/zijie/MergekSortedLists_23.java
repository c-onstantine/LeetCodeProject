package com.liming.zijie;

import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2021-10-08 20:57
 * 23. 合并K个升序链表
 */
public class MergekSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
            if (head.next != null) {
                queue.offer(head.next);
            }
        }
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
