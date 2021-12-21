package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-21 15:51
 */
public class Offer_II_047 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (root.val == 0 && left == null && right == null) {
            return null;
        }
        root.left = left;
        root.right = right;
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
