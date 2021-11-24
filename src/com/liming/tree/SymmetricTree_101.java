package com.liming.tree;

/**
 * @author ltf
 * @date 2021-08-26 16:01
 * 101. 对称二叉树  比较两个子树是否对称  也就是 两树的 外侧点 和内侧点 是否相同
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        return digui(root.left, root.right);
    }

    private boolean digui(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null || (left.val != right.val)) return false;
        return digui(left.left, right.right) && digui(left.right, right.left);
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
