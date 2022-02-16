package com.liming.zijie;

/**
 * @author ltf
 * @date 2022-02-16 21:23
 * 329. 矩阵中的最长递增路径
 * <p>
 * 记忆化搜索
 */
public class LongestIncreasingPathinaMatrix_329 {
    private int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int ans = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        ++cache[i][j];
        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && matrix[i][j] < matrix[ni][nj]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, ni, nj, cache) + 1);
            }
        }
        return cache[i][j];
    }
}
