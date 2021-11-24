package com.liming.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ltf
 * @date 2021-08-02 8:48
 * 559. N 叉树的最大深度
 */
public class MaximumDepthofNaryTree_559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.children != null && poll.children.size() > 0) {
                    for (Node child : poll.children) {
                        queue.offer(child);
                    }
                }
            }
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
}
