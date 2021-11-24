package com.liming.tree;

/**
 * @author ltf
 * @date 2021-02-17 11:36
 */
public class BTreeMaxPathSum124 {
    private int maxsum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        vismax(root);
        return maxsum;
    }

    private int vismax(TreeNode node) {
        if (node == null) return 0;
        int leftval = Math.max(0, vismax(node.left));
        int rightval = Math.max(0, vismax(node.right));
        maxsum = Math.max(maxsum, node.val + leftval + rightval);
        return node.val + Math.max(leftval, rightval);
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
