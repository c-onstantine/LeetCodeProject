package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-10-21 20:59
 * 124. 二叉树中的最大路径和
 */
public class BinaryTreeMaximuPathSum_124 {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, root.val + left + right);
        int max = Math.max(root.val + left, root.val + right);
        return max < 0 ? 0 : max;
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
