package com.liming.dfs;

/**
 * @author ltf
 * @date 2021-07-07 20:05
 * 695. 岛屿的最大面积
 */
public class Max_of_Island_695 {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j, 0));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int x, int y, int area) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return area;
        }
        grid[x][y] = 0;
        area++;
        return area + dfs(grid, x + 1, y, 0)
                + dfs(grid, x - 1, y, 0)
                + dfs(grid, x, y + 1, 0)
                + dfs(grid, x, y - 1, 0);
    }
}
