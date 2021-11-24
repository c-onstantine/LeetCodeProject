package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-26 11:00
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
