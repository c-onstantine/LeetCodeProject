package com.liming.mid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2022-04-07 14:27
 * 1162. 地图分析
 */
public class AsFarfromLandasPossible_1162 {
    public int maxDistance(int[][] grid) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        Deque<int[]> queue = new ArrayDeque<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        // 没有陆地 直接返回
        if (queue.isEmpty()) {
            return -1;
        }

        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] != 0) {
                    continue;
                }
                hasOcean = true;
                grid[nx][ny] = grid[point[0]][point[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        if (!hasOcean) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }
}
