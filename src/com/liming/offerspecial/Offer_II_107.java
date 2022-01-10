package com.liming.offerspecial;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2022-01-10 18:23
 */
public class Offer_II_107 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] res = new int[mat.length][mat[0].length];
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] ints : direction) {
                    int x = poll[0] + ints[0];
                    int y = poll[1] + ints[1];
                    if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && !vis[x][y]) {
                        res[x][y] = step + 1;
                        vis[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            step++;
        }
        return res;
    }
}
