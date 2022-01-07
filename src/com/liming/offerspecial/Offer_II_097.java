package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-07 18:04
 */
public class Offer_II_097 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1][0] = 1; // 只有子序列是空串 才匹配 所有都是1
            for (int j = 0; j <= i && j < t.length(); j++) {
                dp[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? dp[i][j + 1] + dp[i][j] : dp[i][j + 1];
            }
        }
        return dp[s.length()][t.length()];
    }
}
