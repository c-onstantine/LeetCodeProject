package com.liming.offeragain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-11-11 20:30
 */
public class Offer_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode r = stack.pollFirst();
            if (r.left != null) stack.offerFirst(r.left);
            if (r.right != null) stack.offerFirst(r.right);
            TreeNode tmp = r.left;
            r.left = r.right;
            r.right = tmp;
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
