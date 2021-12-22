package com.liming.offerspecial;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-12-22 17:59
 */
public class Offer_II_050 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Integer, Integer> prefix, int cur, int target) {
        if (root == null) return 0;
        int ret = 0;
        cur += root.val;
        ret += prefix.getOrDefault(cur - target, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        ret += dfs(root.left, prefix, cur, target);
        ret += dfs(root.right, prefix, cur, target);
        prefix.put(cur, prefix.get(cur) - 1);
        return ret;
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
