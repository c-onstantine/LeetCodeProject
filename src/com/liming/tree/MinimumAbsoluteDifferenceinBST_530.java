package com.liming.tree;

/**
 * @author ltf
 * @date 2021-09-02 21:17
 */
public class MinimumAbsoluteDifferenceinBST_530 {
    private TreeNode pre = null;
    private int res = 0x3f3f3f3f;

    public int getMinimumDifference(TreeNode root) {
        digui(root);
        return res;
    }

    private void digui(TreeNode root) {
        if (root == null) return;
        getMinimumDifference(root.left);
        if (pre != null) res = Math.min(res, root.val - pre.val);
        pre = root;
        getMinimumDifference(root.right);
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
