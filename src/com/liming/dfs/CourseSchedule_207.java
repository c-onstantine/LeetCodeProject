package com.liming.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-07-18 10:13
 * 207. 课程表
 */
public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] vis = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(list, vis, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> list, int[] vis, int i) {
        if (vis[i] == -1) return true;
        if (vis[i] == 1) return false;
        vis[i] = 1;
        for (Integer integer : list.get(i)) {
            if (!dfs(list, vis, integer)) return false;
        }
        vis[i] = -1;
        return true;
    }
}
