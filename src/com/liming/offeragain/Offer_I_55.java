package com.liming.offeragain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-11-22 20:03
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class Offer_I_55 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return res;
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
