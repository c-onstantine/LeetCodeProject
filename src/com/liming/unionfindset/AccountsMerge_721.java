package com.liming.unionfindset;

import java.util.*;

/**
 * @author ltf
 * @date 2021-08-01 19:55
 * 721. 账户合并
 */
public class AccountsMerge_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind unionFind = new UnionFind(n);
        Map<String, Integer> emailtoid = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> tmp = accounts.get(i);
            int size = tmp.size();
            for (int j = 1; j < size; j++) {
                if (!emailtoid.containsKey(tmp.get(j))) {
                    emailtoid.put(tmp.get(j), i);
                } else {
                    unionFind.union(i, emailtoid.get(tmp.get(j)));
                }
            }
        }
        Map<Integer, List<String>> idtoemail = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailtoid.entrySet()) {
            int id = unionFind.find(entry.getValue());
            List<String> list = idtoemail.getOrDefault(id, new ArrayList<>());
            list.add(entry.getKey());
            idtoemail.put(id, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : idtoemail.entrySet()) {
            List<String> list = entry.getValue();
            Collections.sort(list);
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(entry.getKey()).get(0));
            tmp.addAll(list);
            res.add(tmp);
        }
        return res;
    }

    private class UnionFind {
        int[] fa;
        int[] rank;

        public UnionFind(int n) {
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
    }
}
