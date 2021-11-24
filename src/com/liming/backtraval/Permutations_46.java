package com.liming.backtraval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-20 10:43
 * 46. 全排列
 */
public class Permutations_46 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        back(nums, new boolean[nums.length]);
        return res;
    }

    private void back(int[] nums, boolean[] vis) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            path.add(nums[i]);
            back(nums, vis);
            vis[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
