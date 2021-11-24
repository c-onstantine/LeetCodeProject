package com.liming.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ltf
 * @date 2021-03-11 18:21
 */
public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayList<Integer> tmp = new ArrayList<>();
        Stack<TreeNode>[] stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        int current = 0;
        int next = 1;
        stacks[current].push(root);
        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            TreeNode pop = stacks[current].pop();
            tmp.add(pop.val);
            if (current == 0) {
                if (pop.left != null) {
                    stacks[next].push(pop.left);
                }
                if (pop.right != null) {
                    stacks[next].push(pop.right);
                }
            } else {
                if (pop.right != null) {
                    stacks[next].push(pop.right);
                }
                if (pop.left != null) {
                    stacks[next].push(pop.left);
                }
            }
            if (stacks[current].isEmpty()) {
                res.add((List<Integer>) tmp.clone());
                tmp.clear();
                current = 1 - current;
                next = 1 - next;
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
