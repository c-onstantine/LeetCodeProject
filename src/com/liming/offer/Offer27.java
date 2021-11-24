package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-05 21:12
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
