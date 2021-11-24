package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-22 20:15
 * 剑指 Offer 55 - II. 平衡二叉树
 */
public class Offer_II_55 {
    public boolean isBalanced(TreeNode root) {
        return dfsLastOrder(root) != -1;
    }

    private int dfsLastOrder(TreeNode root) {
        if (root == null) return 0;
        int left = dfsLastOrder(root.left);
        if (left == -1) return -1;
        int right = dfsLastOrder(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
