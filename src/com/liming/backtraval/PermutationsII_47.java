package com.liming.backtraval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-20 11:12
 * 47. 全排列 II
 */
public class PermutationsII_47 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        back(nums, new boolean[nums.length]);
        return res;
    }

    private void back(int[] nums, boolean[] vis) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !vis[i - 1]) continue;
            if (!vis[i]) {
                vis[i] = true;
                path.add(nums[i]);
                back(nums, vis);
                vis[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
