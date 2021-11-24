package com.liming.tree;

/**
 * @author ltf
 * @date 2021-08-30 19:50
 */
public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum - root.val);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null && targetSum == 0) return true;
        if (root.left == null && root.right == null) return false;
        if (root.left != null) {
            if (dfs(root.left, targetSum - root.left.val)) return true;
        }
        if (root.right != null) {
            if (dfs(root.right, targetSum - root.right.val)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PathSum_112 p = new PathSum_112();
        TreeNode root = p.new TreeNode(1, p.new TreeNode(2), p.new TreeNode(3));
        p.hasPathSum(root, 5);
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
