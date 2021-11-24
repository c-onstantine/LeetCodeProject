package com.liming.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-26 15:10
 * 429. N 叉树的层序遍历
 */
public class NaryTreeLevelOrderTraversal_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                tmp.add(poll.val);
                for (Node child : poll.children) {
                    if (child != null) queue.offer(child);
                }
            }
            res.add(tmp);
        }
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

    ;

}
