package com.liming.unionfindset;

/**
 * @author ltf
 * @date 2021-07-13 19:41
 * 959. 由斜杠划分区域
 */
public class Regions_By_Slashes_959 {
    private int[] fa;
    private int[] rank;
    private int count;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        init(4 * n * n);
        for (int i = 0; i < n; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                if (chars[j] == '/') {
                    union(index, index + 3);
                    union(index + 1, index + 2);
                } else if (chars[j] == '\\') {
                    union(index, index + 1);
                    union(index + 2, index + 3);
                } else {
                    union(index, index + 1);
                    union(index + 1, index + 2);
                    union(index + 2, index + 3);
                }
                if (j + 1 < n) {
                    union(index + 1, 4 * (i * n + j + 1) + 3);
                }
                if (i + 1 < n) {
                    union(index + 2, 4 * ((i + 1) * n + j));
                }
            }
        }
        return count;
    }

    private void init(int n) {
        this.count = n;
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
        if (xx != yy) {
            count--;
            if (rank[xx] == rank[yy]) {
                rank[yy]++;
            }
        }
    }
}
