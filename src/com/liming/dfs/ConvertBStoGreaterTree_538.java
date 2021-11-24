package com.liming.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-07-29 20:21
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBStoGreaterTree_538 {
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur !=null){
            stack.addFirst(cur);
            cur = cur.right;
        }
        while (!stack.isEmpty()){
            TreeNode tmp = stack.removeFirst();
            sum+=tmp.val;
            tmp.val = sum;
            tmp = tmp.left;
            while (tmp !=null){
                stack.addFirst(tmp);
                tmp = tmp.right;
            }
        }
        return root;
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
