package com.liming.everyday.in202112;

/**
 * @author ltf
 * @date 2021-12-07 19:12
 */
public class Day7_ColoringABorder_1034 {
    private int[] xi = new int[]{-1, 1, 0, 0};
    private int[] yi = new int[]{0, 0, -1, 1};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, new boolean[grid.length][grid[0].length], row, col, grid[row][col], color);
        return grid;
    }

    private void dfs(int[][] grid, boolean[][] vis, int row, int col, int oldcolor, int color) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || vis[row][col] || grid[row][col] != oldcolor)
            return;
        if (check(grid, vis, row, col, oldcolor)) {
            grid[row][col] = color;
        }
        vis[row][col] = true;
        for (int i = 0; i < 4; i++) {
            dfs(grid, vis, row + xi[i], col + yi[i], oldcolor, color);
        }
    }

    private boolean check(int[][] grid, boolean[][] vis, int row, int col, int oldcolor) {
        if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) return true;
        for (int i = 0; i < 4; i++) {
            if (!vis[row + xi[i]][col + yi[i]] && grid[row + xi[i]][col + yi[i]] != oldcolor)
                return true;//在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
        }
        return false;
    }
}
