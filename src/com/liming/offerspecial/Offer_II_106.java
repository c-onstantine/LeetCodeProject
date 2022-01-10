package com.liming.offerspecial;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author ltf
 * @date 2022-01-10 12:28
 * 二分图 bfs
 */
public class Offer_II_106 {
    public boolean isBipartite(int[][] graph) {
        //0 红色，1 蓝色
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, color, i)) return false;
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int[] color, int x) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        color[x] = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i : graph[poll]) {
                if (color[i] == color[poll]) return false;
                else if (color[poll] == 1 - color[i]) continue;
                else {
                    color[i] = 1 - color[poll];
                    queue.offer(i);
                }
            }
        }
        return true;
    }
}
