package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-12 11:47
 * 剑指 Offer II 112. 最长递增路径
 * 记忆化搜索， dp+深搜
 */
public class Offer_II_112 {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, dp, i, j, -1));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j, int pre) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;
        if (matrix[i][j] <= pre) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        int up = dfs(matrix, dp, i - 1, j, matrix[i][j]);
        int down = dfs(matrix, dp, i + 1, j, matrix[i][j]);
        int left = dfs(matrix, dp, i, j - 1, matrix[i][j]);
        int right = dfs(matrix, dp, i, j + 1, matrix[i][j]);
        dp[i][j] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        return dp[i][j];
    }
}
