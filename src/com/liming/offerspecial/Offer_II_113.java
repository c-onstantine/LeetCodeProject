package com.liming.offerspecial;

import java.util.*;

/**
 * @author ltf
 * @date 2022-01-12 13:16
 */
public class Offer_II_113 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> tmp = map.getOrDefault(prerequisite[1], new ArrayList<>());
            tmp.add(prerequisite[0]);
            map.put(prerequisite[1], tmp);
            in[prerequisite[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        //入度为0 可以作为学习的起始节点
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            res[index++] = poll;
            if (map.containsKey(poll)) {
                for (Integer i : map.get(poll)) {
                    in[i]--;
                    if (in[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }

    //public static void main(String[] args) {
    //    new Offer_II_113().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    //}
}
