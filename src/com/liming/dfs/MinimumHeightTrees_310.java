package com.liming.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ltf
 * @date 2021-07-22 19:54
 * 310. 最小高度树
 */
public class MinimumHeightTrees_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            res.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                res.add(poll);
                List<Integer> list = tree.get(poll);
                for (Integer integer : list) {
                    degree[integer]--;
                    if (degree[integer] == 1) queue.offer(integer);
                }
            }
        }
        return res;
    }
}
