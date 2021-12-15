package com.liming.offerspecial;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-12-15 19:53
 */
public class Offer_II_028 {
    public Node flatten(Node head) {
        if (head == null) return null;
        Node dummy = new Node();
        Deque<Node> stack = new LinkedList<>();
        Node pre = dummy;
        stack.offerFirst(head);
        while (!stack.isEmpty()) {
            Node node = stack.pollFirst();
            pre.next = node;
            node.prev = pre;
            if (node.next != null) {
                stack.offerFirst(node.next);
            }
            if (node.child != null) {
                stack.offerFirst(node.child);
                node.child = null;
            }
            pre = node;
        }
        dummy.next.prev = null;
        return dummy.next;
    }


    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
