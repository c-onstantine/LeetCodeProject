package com.liming.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-07-17 10:51
 * 199. 二叉树的右视图
 */
public class BinTRightSideView_199 {
    private List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int deep) {
        if (node == null) return;
        if (deep == res.size()) {
            res.add(node.val);
        }
        deep++;
        dfs(node.right, deep);
        dfs(node.left, deep);
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
