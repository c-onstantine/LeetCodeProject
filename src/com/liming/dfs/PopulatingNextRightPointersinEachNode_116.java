package com.liming.dfs;

import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-07-15 20:20
 * 116. 填充每个节点的下一个右侧节点指针
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class PopulatingNextRightPointersinEachNode_116 {
    public Node connect(Node root) {
        if (root == null) return null;
        Node pre = root;
        while (pre.left != null) {
            Node tmp = pre;
            while (tmp != null) {
                tmp.left.next = tmp.right;
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            pre = pre.left;
        }
        return root;
    }


    public Node connect1(Node root) {
        if (root == null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (pre != null) {
                    pre.next = poll;
                }
                pre = poll;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }


    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
