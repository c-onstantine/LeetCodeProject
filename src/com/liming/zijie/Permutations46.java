package com.liming.zijie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-10-14 19:43
 * 46. 全排列
 */
public class Permutations46 {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), res, vis);
        return res;
    }

    private void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> res, boolean[] vis) {
        if (nums.length == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            tmp.add(nums[i]);
            vis[i] = true;
            dfs(nums, tmp, res, vis);
            vis[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
