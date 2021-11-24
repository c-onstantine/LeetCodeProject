package com.liming.tree;


/**
 * @author ltf
 * @date 2020-10-20 20:24
 *
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class AVLTree {
    public boolean isBalanced(TreeNode root) {
        return searchTree(root)!=-1;
    }
    public int searchTree(TreeNode root){
        if(root==null) return 0;
        int left=searchTree(root.left);
        if(left==-1)return -1;
        int right=searchTree(root.right);
        if(right==-1) return -1;
        return Math.abs(left-right)<=1?Math.max(left,right)+1:-1;
    }
}
