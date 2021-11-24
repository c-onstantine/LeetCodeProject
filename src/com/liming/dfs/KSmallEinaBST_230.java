package com.liming.dfs;

/**
 * @author ltf
 * @date 2021-07-21 19:57
 * 230. 二叉搜索树中第K小的元素
 */
public class KSmallEinaBST_230 {
    private int res;
    private int num = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        if (++num == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
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
