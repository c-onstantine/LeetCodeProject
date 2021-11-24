package com.liming.tree;

/**
 * @author ltf
 * @date 2021-08-26 19:39
 *
 */
public class MinimumDepthofBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null) return minDepth(root.right) + 1;
        if (root.right == null && root.left != null) return minDepth(root.left) + 1;
        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }

    public class TreeNode {
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
