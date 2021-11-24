package com.liming.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-07-27 20:35
 * 501. 二叉搜索树中的众数
 */
public class FindModeinBinarySearchTree_501 {
    private int base, count, maxcount;
    private List<Integer> ans;

    public int[] findMode(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int x) {
        if (x == base) {
            count++;
        } else {
            base = x;
            count = 1;
        }
        if (count == maxcount) {
            ans.add(base);
        } else if (count > maxcount) {
            maxcount = count;
            ans.clear();
            ans.add(base);
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
