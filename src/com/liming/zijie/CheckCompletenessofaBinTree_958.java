package com.liming.zijie;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2022-02-08 16:04
 */
public class CheckCompletenessofaBinTree_958 {
    public boolean isCompleteTree(TreeNode root) {
        TreeNode pre = root;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (pre == null && node != null) {
                return false;
            }
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
            pre = node;
        }
        return true;
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
