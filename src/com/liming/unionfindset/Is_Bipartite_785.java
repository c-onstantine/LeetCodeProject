package com.liming.unionfindset;

/**
 * @author ltf
 * @date 2021-07-10 19:50
 */
public class Is_Bipartite_785 {
    private int[] fa;
    private int[] rank;

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        init(len);
        for (int i = 0; i < len; i++) {
            int[] to = graph[i];
            for (int j : to) {
                if (isConnected(i, j)) {
                    return false;
                }
                union(to[0], j);
            }
        }
        return true;
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
}
