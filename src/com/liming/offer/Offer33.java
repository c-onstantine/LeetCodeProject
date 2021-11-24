package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-11 20:27
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


    public static void main(String[] args) {
        int[] tmp = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(new Offer33().verifyPostorder(tmp));
    }
}
