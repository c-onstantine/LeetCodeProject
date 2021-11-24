package com.liming.mietun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-10-28 20:40
 * 78. 子集
 */
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        traceBack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void traceBack(int[] nums, int start, List<Integer> tmp, List<List<Integer>> res) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            traceBack(nums, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
