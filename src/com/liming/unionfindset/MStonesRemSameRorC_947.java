package com.liming.unionfindset;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-07-13 9:11
 * 947. 移除最多的同行或同列石头
 */
public class MStonesRemSameRorC_947 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind set = new UnionFind(n);
        for (int[] stone : stones) {
            set.union(stone[0] + 10001, stone[1]);
        }
        return n - set.getCount();
    }

    private class UnionFind {
        private Map<Integer, Integer> fa, rank;
        private int count;

        UnionFind(int n) {
            fa = new HashMap<>();
            rank = new HashMap<>();
            count = 0;
        }

        public int find(int x) {
            if (!fa.containsKey(x)) {
                fa.put(x, x);
                count++;
            }
            if (x != fa.get(x)) {
                fa.put(x, find(fa.get(x)));
            }
            return fa.get(x);
        }

        public void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            rank.putIfAbsent(xx, 1);
            rank.putIfAbsent(yy, 1);
            if (rank.get(xx) <= rank.get(yy)) {
                fa.put(xx, yy);
            } else {
                fa.put(yy, xx);
            }
            if (xx != yy) {
                count--;
                if (rank.get(xx) == rank.get(yy)) {
                    rank.put(yy, rank.get(yy) + 1);
                }
            }
        }

        public int getCount() {
            return count;
        }
    }
}
