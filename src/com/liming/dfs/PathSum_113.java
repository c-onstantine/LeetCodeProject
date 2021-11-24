package com.liming.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-07-14 20:15
 */
public class PathSum_113 {
    //public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    //    List<List<Integer>> res = new ArrayList<>();
    //    dfs(root, targetSum, new ArrayList<>(), res);
    //    return res;
    //}

    //private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
    //    if (root == null) return;
    //    list.add(root.val);
    //    if (root.left == null && root.right == null) {
    //        if (sum == root.val) {
    //            res.add(new ArrayList<>(list));
    //        }
    //        list.remove(list.size() - 1);
    //        return;
    //    }
    //    dfs(root.left, sum - root.val, list, res);
    //    dfs(root.right, sum - root.val, list, res);
    //    list.remove(list.size() - 1);
    //}

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return null;
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum - root.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val);
            path.remove(path.size() - 1);
        }
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
