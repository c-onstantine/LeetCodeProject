package com.liming.offerspecial;

import java.util.*;

/**
 * @author ltf
 * @date 2022-01-14 10:18
 */
public class Offer_II_117 {
    public int numSimilarGroups(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], new ArrayList<>());
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    map.get(strs[i]).add(strs[j]);
                }
            }
        }
        int res = 0;
        boolean[] vis = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!vis[i]) {
                bfs(strs, i, map, vis);
                res++;
            }
        }
        return res;
    }

    private void bfs(String[] strs, int i, Map<String, List<String>> map, boolean[] vis) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(strs[i]);
        vis[i] = true;
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            for (int j = 0; j < strs.length; j++) {
                if (!vis[j] && map.get(poll).contains(strs[j])) {
                    queue.offer(strs[j]);
                    vis[j] = true;
                }
            }
        }
    }

    private boolean isSimilar(String s1, String s2) {
        int count = 0;
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count <= 2;
    }
}
