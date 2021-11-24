package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-13 9:28
 * 剑指 Offer 28. 对称的二叉树
 */
public class Offer_28 {
    public boolean isSymmetric(TreeNode root) {
        return digui(root, root);
    }

    private boolean digui(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return digui(a.left, b.right) && digui(a.right, b.left);
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
