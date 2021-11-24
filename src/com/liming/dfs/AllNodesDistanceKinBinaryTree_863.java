package com.liming.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-08-05 19:06
 */
public class AllNodesDistanceKinBinaryTree_863 {
    private Map<Integer, TreeNode> map = new HashMap<>();
    private List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findfFather(root);

        dfs(target, null, 0, k);
        return res;
    }

    private void findfFather(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            findfFather(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            findfFather(root.right);
        }
    }

    private void dfs(TreeNode target, TreeNode from, int deepth, int k) {
        if (target == null) return;
        ;
        if (deepth == k) {
            res.add(target.val);
            return;
        }
        if (target.left != from) {
            dfs(target.left, target, deepth + 1, k);
        }
        if (target.right != from) {
            dfs(target.right, target, deepth + 1, k);
        }
        if (map.get(target.val) != from) {
            dfs(map.get(target.val), target, deepth + 1, k);
        }
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
