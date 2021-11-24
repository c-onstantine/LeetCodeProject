package com.liming.unionfindset;

/**
 * @author ltf
 * @date 2021-07-08 19:41
 */
public class Couple_Hold_Hands_765 {
    private int[] fa;
    private int[] rank;
    private int count;

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int n = len / 2;
        init(n);
        for (int i = 0; i < len; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }
        return n - count;
    }

    private void init(int n) {
        fa = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
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

    private int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }
}
