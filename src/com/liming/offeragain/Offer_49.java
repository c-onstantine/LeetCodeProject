package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-12-05 11:37
 */
public class Offer_49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        int n1 = 0, n2 = 0, n3 = 0;
        for (int i = 1; i < n; i++) {
            n1 = dp[a] * 2;
            n2 = dp[b] * 3;
            n3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n1, n2), n3);
            if (dp[i] == n1) a++;
            if (dp[i] == n2) b++;
            if (dp[i] == n3) c++;
        }
        return dp[n - 1];
    }
}
