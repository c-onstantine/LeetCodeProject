package com.liming.backtraval;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-19 14:36
 * 40. 组合总和 II
 */
public class CombinationSumII_40 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] vis = new boolean[candidates.length];
        Arrays.sort(candidates);
        back(candidates, target, 0, vis);
        return res;
    }

    private void back(int[] candidates, int target, int start, boolean[] vis) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !vis[i - 1]) continue;
            vis[i] = true;
            target -= candidates[i];
            path.add(candidates[i]);
            back(candidates, target, i + 1, vis);
            vis[i] = false;
            target += candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
