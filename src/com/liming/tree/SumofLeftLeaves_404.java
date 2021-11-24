package com.liming.tree;

/**
 * @author ltf
 * @date 2021-08-30 19:27
 */
public class SumofLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int mid = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            mid = root.left.val;
        }
        return mid + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
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
