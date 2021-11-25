package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-25 19:01
 */
public class Offer_15 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) res++;
            n >>>= 1;
        }
        return res;
    }
}
