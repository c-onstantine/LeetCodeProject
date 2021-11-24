package com.liming.tree;

/**
 * @author ltf
 * @date 2021-08-31 20:04
 */
public class MaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return digui(nums, 0, nums.length);
    }

    private TreeNode digui(int[] nums, int left, int right) {
        if (left >= right) return null;
        int index = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[index]) index = i;
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = digui(nums, left, index);
        node.right = digui(nums, index + 1, right);
        return node;
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
