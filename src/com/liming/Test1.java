package com.liming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ltf
 * @date 2022-02-27 21:30
 */
public class Test1 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),new boolean[candidates.length],0);
        return res;
    }
    private void dfs(int[] candidates,int target,List<Integer> path,boolean[] vis,int index){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length && target - candidates[i] >= 0; i++){
            if (i > 0 && candidates[i] == candidates[i - 1] && vis[i - 1] == false){
                continue;
            }
            vis[i] = true;
            path.add(candidates[i]);
            dfs(candidates,target - candidates[i],path,vis,index + 1);
            path.remove(path.size() - 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        new Test1().combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }

    public static class Inner{
        private int a = 0;
    }
    //private List<List<Integer>> res = new ArrayList<>();
    //private List<Integer> path = new ArrayList<>();

    //public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //    Arrays.sort(candidates);
    //    back(candidates, target, 0, new boolean[candidates.length],new ArrayList<>());
    //    return res;
    //}
    //
    //private void back(int[] candidates, int target, int start, boolean[] vis,List<Integer> path) {
    //    if (target == 0) {
    //        res.add(new ArrayList<>(path));
    //        return;
    //    }
    //    for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
    //        if (i > 0 && candidates[i] == candidates[i - 1] && vis[i - 1] == false) continue;
    //        vis[i] = true;
    //        path.add(candidates[i]);
    //        back(candidates, target - candidates[i], i + 1, vis,path);
    //        path.remove(path.size() - 1);
    //        vis[i] = false;
    //    }
    //}
}
