package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-23 20:55
 */
public class Offer_II_054 {
    int add = 0;

    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        convertBST(root.right);
        root.val += add;
        add = root.val;
        convertBST(root.left);
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
