package com.liming.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-08-26 15:30
 * 翻转二叉树  前序后序 层序遍历 都可以 唯独中序不行，中序会把左右孩子反转两次
 */
public class InvertBinaryTree_226 {
    // 递归先序遍历
    //public TreeNode invertTree(TreeNode root) {
    //    if (root == null) return null;
    //    TreeNode tmp = root.left;
    //    root.left = root.right;
    //    root.right = tmp;
    //    invertTree(root.left);
    //    invertTree(root.right);
    //    return root;
    //}

    // 前序非递归
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode poll = stack.pollFirst();
            TreeNode tmp = poll.left;
            poll.left = poll.right;
            poll.right = tmp;
            if (poll.right != null) stack.addFirst(poll.right);
            if (poll.left != null) stack.addFirst(poll.left);
        }
        return root;
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
