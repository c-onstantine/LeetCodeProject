package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2022-01-11 11:43
 */
public class Offer_II_110 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, graph, res, new ArrayList<>());
        return res;
    }

    private void dfs(int index, int[][] graph, List<List<Integer>> res, List<Integer> tmp) {
        tmp.add(index);
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i : graph[index]) {
            dfs(i, graph, res, tmp);
            tmp.remove(tmp.size() - 1);
        }

    }
}
