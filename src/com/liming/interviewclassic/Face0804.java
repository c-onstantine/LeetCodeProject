package com.liming.interviewclassic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-05-06 21:24
 */
public class Face0804 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int deep) {
        res.add(new ArrayList<>(tmp));
        for (int i = deep; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
