package com.liming.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ltf
 * @date 2021-03-11 14:51
 */
public class Offer32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayList<Integer> tmp = new ArrayList<>();
        int current = 1;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            tmp.add(poll.val);
            current--;
            if (poll.left != null) {
                queue.offer(poll.left);
                next++;
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                next++;
            }
            if (current == 0) {
                res.add((List<Integer>) tmp.clone());
                tmp.clear();
                current = next;
                next = 0;
            }
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
