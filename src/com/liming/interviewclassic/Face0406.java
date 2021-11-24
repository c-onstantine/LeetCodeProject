package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-04-28 20:14
 * 每次左转 都保存一下当前节点pre 这样 当 p的右子树没有节点时 就返回pre
 */
public class Face0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while (p.val != root.val) {
            if (p.val > root.val) {
                root = root.right;
            } else if (p.val < root.val) {
                pre = root;
                root = root.left;
            }
        }
        if (root.right == null) {
            return pre;
        } else {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
