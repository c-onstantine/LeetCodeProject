package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-24 11:16
 */
public class Offer10_2 {
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int one = 1;
        int two = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = (one + two) % 1000000007;
            one = two;
            two = sum;
        }
        return sum;
    }
}
