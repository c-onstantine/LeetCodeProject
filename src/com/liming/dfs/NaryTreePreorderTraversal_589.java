package com.liming.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-02 9:56
 * 589. N 叉树的前序遍历
 */
public class NaryTreePreorderTraversal_589 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return res;
        res.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
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
