package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-24 10:42
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class Offer_33 {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end) return true;// 有一个或没有元素了 直接true
        int root = postorder[end];
        int p = start;
        while (postorder[p] < root) {
            p++;
        }
        int mid = p; //右子树的第一个节点
        while (p < end) {
            if (postorder[p++] < root) return false;
        }
        return verify(postorder, start, mid - 1) && verify(postorder, mid, end - 1);
    }
}


