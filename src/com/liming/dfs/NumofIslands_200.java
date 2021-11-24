package com.liming.dfs;

/**
 * @author ltf
 * @date 2021-07-05 19:45
 * 200. 岛屿数量
 */
public class NumofIslands_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    dfs(grid, i, j, vis);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y, int[][] vis) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0' || vis[x][y] == 1) {
            return;
        }
        vis[x][y] = 1;
        dfs(grid, x - 1, y, vis);
        dfs(grid, x + 1, y, vis);
        dfs(grid, x, y - 1, vis);
        dfs(grid, x, y + 1, vis);
    }
}
