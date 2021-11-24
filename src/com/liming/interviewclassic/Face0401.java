package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-04-26 20:39
 */
public class Face0401 {
    private boolean[] vis;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        vis = new boolean[graph.length];
        return dfs(graph, start, target);
    }

    private boolean dfs(int[][] graph, int start, int target) {
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (graph[i][0] == start && graph[i][1] == target) {
                    return true;
                }
                vis[i] = true;
                if (graph[i][1] == target && dfs(graph, start, graph[i][0])) {
                    return true;
                }
                vis[i] = false;
            }
        }
        return false;
    }
}
