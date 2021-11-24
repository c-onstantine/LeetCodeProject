package com.liming.backtraval;

import java.util.*;

/**
 * @author ltf
 * @date 2021-08-21 16:04
 * 332. 重新安排行程
 */
public class ReconstructItinerary_332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            PriorityQueue<String> queue = graph.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>());
            queue.offer(ticket.get(1));
        }
        List<String> ans = new ArrayList<>();
        dfs(graph, "JFK", ans);
        return ans;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        PriorityQueue<String> q = graph.get(src);
        while (q != null && !q.isEmpty()) {
            String poll = q.poll();
            dfs(graph, poll, ans);
        }
        ans.add(0, src);
    }
}
