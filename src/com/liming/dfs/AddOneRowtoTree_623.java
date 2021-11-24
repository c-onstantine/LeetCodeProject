package com.liming.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-08-03 18:18
 * 623. 在二叉树中增加一行
 */
public class AddOneRowtoTree_623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode nr = new TreeNode(val);
            nr.left = root;
            return nr;
        }
        int index = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (index == depth - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.pollLast();
                    TreeNode nl = new TreeNode(val);
                    TreeNode nr = new TreeNode(val);
                    if (poll.left != null) {
                        nl.left = poll.left;
                    }
                    if (poll.right != null) {
                        nr.right = poll.right;
                    }
                    poll.left = nl;
                    poll.right = nr;
                }
                break;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.pollLast();
                    if (poll.left != null) {
                        queue.addFirst(poll.left);
                    }
                    if (poll.right != null) {
                        queue.addFirst(poll.right);
                    }
                }
                index++;
            }
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
