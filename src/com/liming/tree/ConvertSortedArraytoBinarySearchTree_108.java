package com.liming.tree;

/**
 * @author ltf
 * @date 2021-09-07 19:21
 * 108. 将有序数组转换为二叉搜索树
 */
public class ConvertSortedArraytoBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sorted(nums, 0, nums.length - 1);

    }

    private TreeNode sorted(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sorted(nums, left, mid - 1);
        root.right = sorted(nums, mid + 1, right);
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
