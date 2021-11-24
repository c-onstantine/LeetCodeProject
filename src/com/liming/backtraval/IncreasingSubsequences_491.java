package com.liming.backtraval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-19 21:04
 * 491. 递增子序列
 */
public class IncreasingSubsequences_491 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        back(nums, 0);
        return res;
    }

    private void back(int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        int[] set = new int[201];
        for (int i = start; i < nums.length; i++) {
            if ((path.size() > 0 && nums[i] < path.get(path.size() - 1)) || set[nums[i] + 100] == 1) {
                continue;
            }
            path.add(nums[i]);
            set[nums[i] + 100] = 1;
            back(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
