package com.liming.unionfindset;

/**
 * @author ltf
 * @date 2021-07-07 19:24
 * 684. 冗余连接
 */
public class Redundant_Connection_684 {
    private int[] fa;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        init(n);
        for (int i = 0; i < n; i++) {
            int v1 = find(edges[i][0]);
            int v2 = find(edges[i][1]);
            if (v1 == v2) {
                return edges[i];
            } else {
                union(v1, v2);
            }
        }
        return new int[]{0, 0};
    }

    private void init(int n) {
        fa = new int[n+1];
        rank = new int[n+1];
        for (int i = 1; i <= n; i++) {
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
        if (rank[xx] == rank[yy] && xx != yy) {
            rank[yy]++;
        }
    }

    private int find(int x) {
        return x == fa[x] ? x :  (fa[x]=find(fa[x]));
    }

}
