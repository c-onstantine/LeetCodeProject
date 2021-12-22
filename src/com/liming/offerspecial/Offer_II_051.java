package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-22 19:21
 */
public class Offer_II_051 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int ret = Math.max(root.val, root.val + Math.max(left, right));
        res = Math.max(res, Math.max(ret, root.val + left + right));
        return ret;
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
