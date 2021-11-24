package com.liming.unionfindset;

/**
 * @author ltf
 * @date 2021-07-12 19:44
 * 886. 可能的二分法
 */
public class PossibleBipartition_886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        UnionSet set = new UnionSet(n * 2 + 1);
        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            int da = n + a;
            int db = n + b;
            if (set.isConnected(a, b)) {
                return false;
            }
            set.union(a, db);
            set.union(b, da);
        }
        return true;
    }

    private class UnionSet {
        private int[] fa;
        private int[] rank;

        public UnionSet(int n) {
            fa = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void union(int x, int y) {
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

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
