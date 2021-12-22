package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-12-22 19:40
 */
public class Offer_II_052 {
    private List<Integer> list;

    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        TreeNode head = new TreeNode(list.get(0));
        TreeNode cur = head;
        int i = 1;
        while (i < list.size()) {
            cur.right = new TreeNode(list.get(i));
            i++;
            cur = cur.right;
        }
        return head;
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
