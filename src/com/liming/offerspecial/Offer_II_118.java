package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2022-01-14 11:26
 */
public class Offer_II_118 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int i = 0; i < edges.length; i++) {
            int fa0 = unionFind.find(edges[i][0]);
            int fa1 = unionFind.find(edges[i][1]);
            if (fa0 != fa1) {
                unionFind.union(fa0, fa1);
            } else {
                return edges[i];
            }
        }
        return new int[0];
    }

    private class UnionFind {
        private int[] fa;
        private int[] rank;

        UnionFind(int n) {
            fa = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
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

        private void union(int xx, int yy) {
            if (rank[xx] <= rank[yy]) {
                fa[xx] = yy;
            } else {
                fa[yy] = xx;
            }
            if (rank[xx] == rank[yy] && xx != yy) {
                rank[yy]++;
            }
        }
    }
}
