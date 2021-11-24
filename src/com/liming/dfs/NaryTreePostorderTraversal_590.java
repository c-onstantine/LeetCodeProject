package com.liming.dfs;

import java.util.*;

/**
 * @author ltf
 * @date 2021-08-02 10:24
 * 590. N 叉树的后序遍历
 */
public class NaryTreePostorderTraversal_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Node poll = stack.pollFirst();
            res.add(poll.val);
            for (int i = 0; i < poll.children.size(); i++) {
                if (poll.children.get(i) != null) {
                    stack.addFirst(poll.children.get(i));
                }
            }
        }
        Collections.reverse(res);
        return res;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
