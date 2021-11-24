package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-18 21:14
 * 剑指 Offer 13. 机器人的运动范围
 */
public class Offer_13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        return dfs(vis, 0, 0, m, n, k);
    }

    private int dfs(boolean[][] vis, int x, int y, int m, int n, int k) {
        if (x >= m || y >= n || vis[x][y] || shuweiSum(x, y) > k) return 0;
        vis[x][y] = true;
        return 1 + dfs(vis, x + 1, y, m, n, k) + dfs(vis, x, y + 1, m, n, k);
    }

    private int shuweiSum(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
