package com.liming.qiuzhao.codetop.zijie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ltf
 * @date 2022-08-21 17:39
 */
public class CourseTable {
    private boolean isCycle = false;
    private List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        for(int[] t : prerequisites){
            graph[t[1]][t[0]] = 1;
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            bfs(graph,vis,inPath,i);
        }
        if(isCycle)return new int[0];
        Collections.reverse(res);
        return res.stream().mapToInt((x)->x).toArray();
    }
    private void bfs(int[][] graph,boolean[] vis,boolean[] inPath,int index){
        if(isCycle){
            return;
        }
        vis[index] = true;
        inPath[index] = true;
        for(int i = 0; i < graph[index].length; i++){
            if(graph[index][i] == 1 && !vis[i]){
                if(inPath[i]){
                    isCycle = true;
                    return;
                }else{
                    bfs(graph,vis,inPath,i);
                }
            }
        }
        res.add(index);
        inPath[index] = false;
    }

    public static void main(String[] args) {
        new CourseTable().findOrder(2,new int[][]{{1,0}});
    }
}
