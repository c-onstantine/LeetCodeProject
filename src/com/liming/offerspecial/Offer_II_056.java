package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-12-24 11:27
 */
public class Offer_II_056 {
    private List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int left = 0, right = list.size() - 1, tmp = 0;
        while (left < right) {
            tmp = list.get(left) + list.get(right);
            if (tmp == k) {
                return true;
            } else if (tmp < k) {
                left++;
            } else if (tmp > k) {
                right--;
            }
        }
        return false;
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
