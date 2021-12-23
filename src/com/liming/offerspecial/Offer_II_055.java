package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-12-23 21:05
 */
public class Offer_II_055 {
    private int cur = 0; //遍历指针
    private List<Integer> list = new ArrayList<>(); // 存放中序遍历的结果

    public Offer_II_055(TreeNode root) {
        inorder(root);
    }

    public int next() {
        return list.get(cur++);
    }

    public boolean hasNext() {
        return cur < list.size();
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
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
