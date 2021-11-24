package com.liming.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-07-27 19:11
 * 449. 序列化和反序列化二叉搜索树
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = TreeToString(new StringBuilder(), root);
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        Deque<Integer> nums = new ArrayDeque<>();
        for (String s : data.split(" ")) {
            nums.add(Integer.valueOf(s));
        }
        return helper(nums, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private StringBuilder TreeToString(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return sb;
        }
        sb = TreeToString(sb, root.left);
        sb = TreeToString(sb, root.right);
        sb.append(root.val);
        sb.append(" ");
        return sb;
    }

    private TreeNode helper(Deque<Integer> nums, int low, int high) {
        if (nums.isEmpty()) {
            return null;
        }
        int val = nums.getLast();
        if (val < low || val > high) return null;
        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(nums, val, high);
        root.left = helper(nums, low, val);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

