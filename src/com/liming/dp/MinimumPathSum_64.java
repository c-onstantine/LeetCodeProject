package com.liming.dp;

/**
 * @author ltf
 * @date 2021-08-09 10:26
 * 64. 最小路径和
 */
public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            index += grid[i][0];
            dp[i][0] = index;
        }
        index = 0;
        for (int i = 0; i < n; i++) {
            index += grid[0][i];
            dp[0][i] = index;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
