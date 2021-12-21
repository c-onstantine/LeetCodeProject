package com.liming.offerspecial;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-12-21 16:07
 */
public class Offer_II_048 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Deque<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                sb.append(poll.val + ",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            } else {
                sb.append("null,");
            }
        }
        return sb.substring(0, sb.length() - 1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;
        String[] split = data.replaceAll("\\[|\\]", "").split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (!split[i].equals("null")) {
                poll.left = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(poll.left);
            }
            i++;
            if (!split[i].equals("null")) {
                poll.right = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(poll.right);
            }
            i++;
        }
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
