package com.liming.unionfindset;

/**
 * @author ltf
 * @date 2021-07-08 21:23
 * 778. 水位上升的泳池中游泳
 */
public class Swim_Rising_Water_778 {
    private int[] fa;
    private int[] rank;
    private int N;

    public int swimInWater(int[][] grid) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        N = grid.length;
        int len = N * N;
        init(len);
        int[] index = new int[len];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                index[grid[i][j]] = getIndex(i, j);
            }
        }
        for (int i = 0; i < len; i++) {
            int x = index[i] / N;
            int y = index[i] % N;
            for (int[] d : dir) {
                int xx = x + d[0];
                int yy = y + d[1];
                if (isArea(xx, yy) && grid[xx][yy] <= i) {
                    union(index[i], getIndex(xx, yy));
                }
                if (isConnected(0, len - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void init(int n) {
        fa = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int x) {
        while (x != fa[x]) {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;
    }

    private void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (rank[xx] <= rank[yy]) {
            fa[xx] = yy;
        } else {
            fa[yy] = xx;
        }
        if (rank[xx] == rank[yy] && xx != yy) {
            rank[yy]++;
        }
    }

    private boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    private int getIndex(int x, int y) {
        return x * N + y;
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
