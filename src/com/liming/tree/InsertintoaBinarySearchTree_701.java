package com.liming.tree;

/**
 * @author ltf
 * @date 2021-09-06 19:44
 */
public class InsertintoaBinarySearchTree_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        TreeNode cur = root;
        TreeNode fa = root;
        while (cur != null) {
            fa = cur;
            if (cur.val > val) cur = cur.left;
            else if (cur.val < val) cur = cur.right;
        }
        if (fa.val < val) {
            fa.right = new TreeNode(val);
        } else if (fa.val > val) {
            fa.left = new TreeNode(val);
        }
        return root;
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
