package com.liming.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-02 16:55
 * 797. 所有可能的路径
 */
public class AllPathsFromSourceTarget_797 {
    private List<List<Integer>> res;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        dfs(0, graph, new LinkedList<>());
        return res;
    }

    private void dfs(int n, int[][] graph, LinkedList<Integer> paths) {
        if (n == graph.length - 1) {
            paths.add(n);
            res.add(new ArrayList<>(paths));
            return;
        }
        paths.add(n);
        for (int i = 0; i < graph[n].length; i++) {
            dfs(graph[n][i], graph, paths);
            paths.removeLast();
        }
    }
}
