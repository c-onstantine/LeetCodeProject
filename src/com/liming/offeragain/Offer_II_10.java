package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-13 9:52
 */
public class Offer_II_10 {
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int dp1 = 1, dp2 = 2, tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = (dp1 + dp2) % 1000000007;
            dp1 = dp2;
            dp2 = tmp;
        }
        return dp2;
    }
}
