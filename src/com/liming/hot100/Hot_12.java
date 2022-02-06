package com.liming.hot100;

import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2022-02-06 15:59
 */
public class Hot_12 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> {
            return x.val - y.val;
        });
        for (ListNode list : lists) {
            // 注意这里的条件 必须要判断非空才加入队列 否则会出错。
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

    private static class ListNode {
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

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode c = new ListNode(2);
        c.next = new ListNode(6);

        ListNode[] list = new ListNode[]{a, b, c};

        new Hot_12().mergeKLists(list);
    }
}
