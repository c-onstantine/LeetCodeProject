package com.liming.backtraval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-19 20:05
 * 78. 子集
 */
public class Subsets_78 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        back(nums, 0);
        return res;
    }

    private void back(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            back(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
