package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-11 15:41
 * <p>
 * 96. 不同的二叉搜索树
 */
public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
