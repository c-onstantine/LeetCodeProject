package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-21 18:44
 */
public class Offer_II_049 {
    private int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        getSum(root, root.val);
        return res;
    }

    private void getSum(TreeNode root, int val) {
        if (root.left == null && root.right == null) {
            res += val;
            return;
        }
        if (root.left != null) {
            getSum(root.left, val * 10 + root.left.val);
        }
        if (root.right != null) {
            getSum(root.right, val * 10 + root.right.val);
        }
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
