package com.liming.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ltf
 * @date 2021-07-19 19:52
 * 210. 课程表 II
 */
public class CourseScheduleTwo_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];
        List<List<Integer>> course = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            course.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] p : prerequisites) {
            course.get(p[1]).add(p[0]);
            degree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            res[index++] = poll;
            List<Integer> list = course.get(poll);
            for (Integer integer : list) {
                if (--degree[integer] == 0) {
                    queue.offer(integer);
                }
            }
        }
        if (index == numCourses) {
            return res;
        }
        return new int[0];
    }
}
