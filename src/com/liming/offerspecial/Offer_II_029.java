package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-15 20:07
 * 剑指 Offer II 029. 排序的循环链表
 */
public class Offer_II_029 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node cur = head;
        while (cur.next != head) {
            if (cur.val > cur.next.val) {
                if (cur.next.val >= insertVal) {
                    break;
                } else if (cur.val <= insertVal) {
                    break;
                }
            }
            if (cur.val <= insertVal && cur.next.val >= insertVal) {
                break;
            }
            cur = cur.next;
        }
        cur.next = new Node(insertVal, cur.next);
        return head;
    }

    private class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

}
