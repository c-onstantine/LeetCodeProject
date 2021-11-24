package com.liming.offer;

/**
 * @author ltf
 * @date 2021-02-25 12:29
 */
public class Offer13 {
    public int movingCount(int m, int n, int k) {
        if (k < 0 || m <= 0 || n <= 0) return 0;
        boolean[][] vis = new boolean[m][n];
        return dfs(0, 0, m, n, k, vis);
    }

    private int dfs(int row, int col, int m, int n, int k, boolean[][] vis) {
        int count = 0;
        if (row >= 0 && row < m && col >= 0 && col < n && (getDigitSum(row) + getDigitSum(col)) <= k && vis[row][col] == false) {
            vis[row][col] = true;
            count = 1 + dfs(row - 1, col, m, n, k, vis)
                    + dfs(row + 1, col, m, n, k, vis)
                    + dfs(row, col - 1, m, n, k, vis)
                    + dfs(row, col + 1, m, n, k, vis);
        }
        return count;
    }

    private int getDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
