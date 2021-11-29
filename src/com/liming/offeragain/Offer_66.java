package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-27 21:15
 * 每个位置是其他位置元素的乘积   这个利用一维数组 构造一个矩阵  就能清晰的看出 如何利用累乘 求出对应位置的结果。
 */
public class Offer_66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) return new int[0];
        int[] b = new int[len];
        int tmp = 1;
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
