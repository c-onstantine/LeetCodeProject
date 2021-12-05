package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-12-05 16:52
 */
public class Offer_17 {
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
