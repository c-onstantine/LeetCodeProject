package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-19 15:59
 */
public class Offer_54 {
    private int res, count;

    public int kthLargest(TreeNode root, int k) {
        res = 0;
        count = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null || count == 0) return;
        dfs(root.right);
        if (--count == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
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
