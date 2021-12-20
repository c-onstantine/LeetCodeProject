package com.liming.offerspecial;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-12-20 21:07
 */
public class Offer_II_043 {
    private TreeNode root;
    private Deque<TreeNode> queue;

    public Offer_II_043(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode poll = queue.poll();
            queue.offer(poll.left);
            queue.offer(poll.right);
        }
    }

    public int insert(int v) {
        TreeNode front = queue.peek();
        if (front.left == null) {
            front.left = new TreeNode(v);
        } else {
            front.right = new TreeNode(v);
            queue.offer(front.left);
            queue.offer(front.right);
            queue.poll();
        }
        return front.val;
    }

    public TreeNode get_root() {
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
