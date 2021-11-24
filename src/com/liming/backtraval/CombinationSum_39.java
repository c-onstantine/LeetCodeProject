package com.liming.backtraval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-18 20:50
 * 39. 组合总和
 */
public class CombinationSum_39 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        back(candidates, target, 0);
        return res;
    }

    private void back(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            target -= candidates[i];
            path.add(candidates[i]);
            back(candidates, target, i);
            target += candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
