package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-13 14:13
 * 474. 一和零
 */
public class OnesandZeroes_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeronum = 0, onenum = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeronum++;
                else onenum++;
            }
            for (int i = m; i >= zeronum; i--) {
                for (int j = n; j >= onenum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeronum][j - onenum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
