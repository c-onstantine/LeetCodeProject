package com.liming.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-07-26 21:38
 * 437. 路径总和 III
 * 前缀和
 */
public class PathSum3_437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(map, 0, root, targetSum);
    }

    private int dfs(Map<Integer, Integer> map, int cursum, TreeNode root, int target) {
        if (root == null) return 0;
        int res = 0;
        cursum += root.val;
        res += map.getOrDefault(cursum - target, 0);
        map.put(cursum, map.getOrDefault(cursum, 0) + 1);
        res += dfs(map, cursum, root.left, target);
        res += dfs(map, cursum, root.right, target);
        map.put(cursum, map.get(cursum) - 1);
        return res;
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
