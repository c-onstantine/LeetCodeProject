package com.liming.offerspecial;

import java.util.*;

/**
 * @author ltf
 * @date 2022-01-12 10:37
 */
public class Offer_II_111 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //初始化图
        Map<String, List<Map<String, Double>>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            // 存入a->b边
            List<Map<String, Double>> tmp1 = graph.getOrDefault(a, new ArrayList<>());
            Map<String, Double> temp1 = new HashMap<>();
            temp1.put(b, values[i]);
            tmp1.add(temp1);
            graph.put(a, tmp1);
            //存入b->a边
            List<Map<String, Double>> tmp2 = graph.getOrDefault(b, new ArrayList<>());
            Map<String, Double> temp2 = new HashMap<>();
            temp2.put(a, 1 / values[i]);
            tmp2.add(temp2);
            graph.put(b, tmp2);
        }
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        for (int i = 0; i < queries.size(); i++) {
            if (graph.containsKey(queries.get(i).get(0)) && graph.containsKey(queries.get(i).get(1))) {
                Set<String> vis = new HashSet<>();
                res[i] = dfs(graph, vis, queries.get(i).get(0), queries.get(i).get(1), 1.0);
            }
        }
        return res;
    }

    private double dfs(Map<String, List<Map<String, Double>>> graph, Set<String> vis, String a, String b, double val) {
        if (a.equals(b)) {
            return val;
        }
        vis.add(a);
        for (Map<String, Double> map : graph.get(a)) {
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (!vis.contains(entry.getKey())) {
                    double ret = dfs(graph, vis, entry.getKey(), b, entry.getValue() * val);
                    if (ret > 0) {
                        return ret;
                    }
                }
            }
        }
        return -1;
    }
}
