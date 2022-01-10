package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-10 11:49
 */
public class Offer_II_105 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            grid[x][y] = 0;
            return 1 + dfs(grid, x + 1, y) +
                    dfs(grid, x - 1, y) +
                    dfs(grid, x, y - 1) +
                    dfs(grid, x, y + 1);
        }
        return 0;
    }
}
