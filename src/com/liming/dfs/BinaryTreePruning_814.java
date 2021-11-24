package com.liming.dfs;

/**
 * @author ltf
 * @date 2021-08-02 17:37
 * 814. 二叉树剪枝
 */
public class BinaryTreePruning_814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null || !hasOne(root)) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }

    private boolean hasOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == 1) {
            return true;
        }
        return hasOne(root.left) || hasOne(root.right);
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
