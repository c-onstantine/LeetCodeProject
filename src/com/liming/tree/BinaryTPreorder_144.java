package com.liming.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-07-17 10:34
 * 前序遍历 递归 和非递归 写法
 */
public class BinaryTPreorder_144 {
    //public List<Integer> preorderTraversal(TreeNode root) {
    //    List<Integer> res = new ArrayList<>();
    //    dfs(root, res);
    //    return res;
    //}

    //递归
    //private void dfs(TreeNode root, List<Integer> res) {
    //    if (root == null) return;
    //    res.add(root.val);
    //    dfs(root.left, res);
    //    dfs(root.right, res);
    //}


    //非递归 朴实写法
    //public List<Integer> preorderTraversal(TreeNode root) {
    //    Deque<TreeNode> stack = new LinkedList<>();
    //    List<Integer> res = new ArrayList<>();
    //    if (root == null) return res;
    //    stack.addFirst(root);
    //    while (!stack.isEmpty()) {
    //        TreeNode poll = stack.pollFirst();
    //        res.add(poll.val);
    //        if (poll.right != null) stack.addFirst(poll.right);
    //        if (poll.left != null) stack.addFirst(poll.left);
    //    }
    //    return res;
    //}

    // 非递归 统一写法
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            if (node != null) {
                if (node.right != null) stack.addFirst(node.right);
                if (node.left != null) stack.addFirst(node.left);
                stack.addFirst(node);
                stack.addFirst(null);
            } else {
                node = stack.pollFirst();
                res.add(node.val);
            }
        }
        return res;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
