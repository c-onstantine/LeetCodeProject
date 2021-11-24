package com.liming.tree;

import java.util.*;

/**
 * @author ltf
 * @date 2021-08-24 21:04
 * 145. 二叉树的后序遍历
 */
public class BinaryTreePostorderTraversal_145 {
    // 递归写法
    //private List<Integer> res = new ArrayList<>();
    //
    //public List<Integer> postorderTraversal(TreeNode root) {
    //    travel(root);
    //    return res;
    //}
    //
    //private void travel(TreeNode root) {
    //    if (root == null) return;
    //    travel(root.left);
    //    travel(root.right);
    //    res.add(root.val);
    //}
    //非递归写法 朴素写法

    //public List<Integer> postorderTraversal(TreeNode root) {
    //    Deque<TreeNode> stack = new LinkedList<>();
    //    List<Integer> res = new ArrayList<>();
    //    if (root != null) stack.addFirst(root);
    //    while (!stack.isEmpty()) {
    //        TreeNode poll = stack.pollFirst();
    //        res.add(poll.val);
    //        if (poll.left != null) stack.addFirst(poll.left);
    //        if (poll.right != null) stack.addFirst(poll.right);
    //    }
    //    Collections.reverse(res);
    //    return res;
    //}

    // 非递归统一写法
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode poll = stack.pollFirst();
            if (poll != null) {
                stack.push(poll);
                stack.push(null);
                if (poll.right != null) stack.push(poll.right);
                if (poll.left != null) stack.push(poll.left);
            } else {
                TreeNode node = stack.pollFirst();
                res.add(node.val);
            }
        }
        return res;
    }

    public class TreeNode {
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
