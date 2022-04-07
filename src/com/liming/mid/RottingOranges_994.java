package com.liming.mid;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2022-04-07 16:35
 */
public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int freshOrangeCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOrangeCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int minutes = 0;
        while (freshOrangeCount > 0 && !queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = poll[0] + dx[j];
                    int ny = poll[1] + dy[j];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1) {
                        continue;
                    }
                    freshOrangeCount--;
                    grid[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        if (freshOrangeCount > 0) {
            return -1;
        } else {
            return minutes;
        }
    }
}
