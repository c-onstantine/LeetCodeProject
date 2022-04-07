package com.liming.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2022-04-07 15:10
 * 226. 翻转二叉树
 */
public class InvertBinaryTree_226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        new InvertBinaryTree_226().invertTree(root);
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode poll = stack.pollFirst();
            swap(poll);
            if (poll.right != null) {
                stack.offerFirst(poll.right);
            }
            if (poll.left != null) {
                stack.offerFirst(poll.left);
            }
        }
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    private static class TreeNode {
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
