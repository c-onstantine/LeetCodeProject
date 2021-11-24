package com.liming.tree;

/**
 * @author ltf
 * @date 2021-08-26 20:53
 */
public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        return digui(root) != -1;
    }

    private int digui(TreeNode root) {
        if (root == null) return 0;
        int left = digui(root.left);
        if (left == -1) return -1;
        int right = digui(root.right);
        if (right == -1) return -1;
        return Math.abs(right - left) > 1 ? -1 : 1 + Math.max(left, right);
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
