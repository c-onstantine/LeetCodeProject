package com.liming.tree;

import java.util.*;

/**
 * @author ltf
 * @date 2021-08-24 21:11
 * 94. 二叉树的中序遍历  递归 非递归
 */
public class BinaryTreeInorderTraversal_94 {
    /*
     * 递归
     * */
    //private List<Integer> res = new ArrayList<>();
    //
    //public List<Integer> inorderTraversal(TreeNode root) {
    //    travel(root);
    //    return res;
    //}
    //
    //private void travel(TreeNode root) {
    //    if (root == null) return;
    //    travel(root.left);
    //    res.add(root.val);
    //    travel(root.right);
    //}

    // 非递归 朴实写法
    //public List<Integer> inorderTraversal(TreeNode root) {
    //    TreeNode cur = root;
    //    Deque<TreeNode> stack = new LinkedList<>();
    //    List<Integer> res = new ArrayList<>();
    //    while (cur != null || !stack.isEmpty()) {
    //        if (cur != null) {
    //            stack.addFirst(cur);
    //            cur = cur.left;
    //        } else {
    //            cur = stack.pollFirst();
    //            res.add(cur.val);
    //            cur = cur.right;
    //        }
    //    }
    //    return res;
    //}

    // 非递归 统一写法
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            if (node != null) {
                if (node.right != null) stack.addFirst(node.right);
                stack.addFirst(node);
                stack.addFirst(null);
                if (node.left != null) stack.addFirst(node.left);
            } else {
                node = stack.pollFirst();
                res.add(node.val);
            }
        }
        return res;
    }

    public class TreeNode {
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
