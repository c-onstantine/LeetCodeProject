package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-23 11:54
 */
public class Offer49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n1 = dp[a] * 2, n2 = dp[b] * 3, n3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n1, n2), n3);
            if (dp[i] == n1) a++;
            if (dp[i] == n2) b++;
            if (dp[i] == n3) c++;
        }
        return dp[n - 1];
    }
}
