package com.liming.dfs;

/**
 * @author ltf
 * @date 2021-07-19 19:22
 * 222. 完全二叉树的节点个数
 */
public class CountCompleteTreeNodes_222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countdeep(root.left);
        int right = countdeep(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    private int countdeep(TreeNode root) {
        int deep = 0;
        while (root != null) {
            deep++;
            root = root.left;
        }
        return deep;
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
