package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-04-28 21:20
 * DFS + 回溯
 */
public class Face0409 {
    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.offerLast(root);
        }
        dfs(deque);
        return res;
    }

    private void dfs(Deque<TreeNode> deque) {
        if (deque.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        int size = deque.size();
        while (size > 0) {
            TreeNode first = deque.pollFirst();
            path.add(first.val);
            int child = 0;
            if (first.left != null) {
                child++;
                deque.offerLast(first.left);
            }
            if (first.right != null) {
                child++;
                deque.offerLast(first.right);
            }
            dfs(deque);
            while (child > 0) {
                child--;
                deque.pollLast();
            }
            deque.offerLast(first);
            path.removeLast();
            size--;
        }
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
