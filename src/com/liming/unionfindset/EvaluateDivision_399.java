package com.liming.unionfindset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ltf
 * @date 2021-07-06 20:08
 * 399. 除法求值
 */
public class EvaluateDivision_399 {
    private int[] fa;
    private double[] weight;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        init(2 * n);
        Map<String, Integer> map = new HashMap<>(2 * n);
        AtomicInteger id = new AtomicInteger();
        for (int i = 0; i < n; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);

            map.computeIfAbsent(s1, x -> id.getAndIncrement());
            map.computeIfAbsent(s2, x -> id.getAndIncrement());
            union(map.get(s1), map.get(s2), values[i]);
        }
        int q = queries.size();
        double[] res = new double[q];
        for (int i = 0; i < q; i++) {
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            Integer id1 = map.get(s1);
            Integer id2 = map.get(s2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = isConnected(id1, id2);
            }
        }
        return res;
    }

    private void init(int n) {
        this.fa = new int[n];
        this.weight = new double[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            weight[i] = 1.0d;
        }
    }

    private void union(int x, int y, double value) {
        int xx = find(x);
        int yy = find(y);
        if (xx == yy) {
            return;
        }
        fa[xx] = yy;
        weight[xx] = weight[y] * value / weight[x];
    }

    private int find(int x) {
        if (x != fa[x]) {
            int ori = fa[x];
            fa[x] = find(fa[x]);
            weight[x] *= weight[ori];
        }
        return fa[x];
    }

    private double isConnected(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx == yy) {
            return weight[x] / weight[y];
        } else {
            return -1.0d;
        }
    }
}
