package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-06 22:26
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 */
public class Offer_II_003 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            //if ((i & 1) == 0) { //偶数0的个数 和它右移一位 一样
            //    res[i] = res[i >> 1];
            //} else {// 奇数 是上一个偶数的1个数 +1；
            //    res[i] = res[i - 1] + 1;
            //}
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
