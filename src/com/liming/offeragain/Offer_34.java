package com.liming.offeragain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-11-19 11:53
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class Offer_34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int target, int sum, List<List<Integer>> res, List<Integer> tmp) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        if (sum + root.val == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(tmp));
        }
        dfs(root.left, target, sum + root.val, res, tmp);
        dfs(root.right, target, sum + root.val, res, tmp);
        tmp.remove(tmp.size() - 1);
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
