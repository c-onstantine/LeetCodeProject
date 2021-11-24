package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-17 14:03
 */
public class UglyNumberII_264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int v1 = dp[p2] * 2;
            int v2 = dp[p3] * 3;
            int v3 = dp[p5] * 5;
            dp[i] = Math.min(v1, Math.min(v2, v3));
            if (dp[i] == v1) {
                p2++;
            }
            if (dp[i] == v2) {
                p3++;
            }
            if (dp[i] == v3) {
                p5++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        new UglyNumberII_264().nthUglyNumber(10);
    }
}
