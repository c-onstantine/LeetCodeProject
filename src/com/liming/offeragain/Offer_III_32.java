package com.liming.offeragain;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-11-11 21:30
 */
public class Offer_III_32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = null;
                if (!flag) {
                    poll = queue.pollFirst();
                    if (poll.left != null) queue.offerLast(poll.left);
                    if (poll.right != null) queue.offerLast(poll.right);
                } else {
                    poll = queue.pollLast();
                    if (poll.right != null) queue.offerFirst(poll.right);
                    if (poll.left != null) queue.offerFirst(poll.left);
                }
                tmp.add(poll.val);
            }
            res.add(tmp);
            flag = !flag;
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
