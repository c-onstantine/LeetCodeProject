package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-29 19:35
 */
public class Offer_I_14 {
    //public int cuttingRope(int n) {
    //    int[] dp = new int[n + 1];
    //    dp[2] = 1;
    //    for (int i = 3; i <= n; i++) {
    //        for (int j = 2; j < i; j++) { // 1截取 不会对乘积有增益 所以从2开始
    //            dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
    //        }
    //    }
    //    return dp[n];
    //}

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        if (b == 2) return (int) Math.pow(3, a) * 2;
        return (int) Math.pow(3, a);
    }
}
