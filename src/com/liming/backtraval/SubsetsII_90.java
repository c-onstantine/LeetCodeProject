package com.liming.backtraval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ltf
 * @date 2021-08-21 10:58
 * 90. 子集 II
 */
public class SubsetsII_90 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        back(nums, 0);
        return res;
    }

    private void back(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        int[] vis = new int[21];
        for (int i = start; i < nums.length; i++) {
            if (vis[nums[i] + 10] == 1) continue;
            vis[nums[i] + 10] = 1;
            path.add(nums[i]);
            back(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    // 错误写法 set设置为全局变量 在回溯的时候 之前记录的值 都已经被清空了
    //private List<List<Integer>> res = new ArrayList<>();
    //private List<Integer> path = new ArrayList<>();
    //private Set<Integer> set = new HashSet<>();
    //public List<List<Integer>> subsetsWithDup(int[] nums) {
    //    Arrays.sort(nums);
    //    back(nums, 0);
    //    return res;
    //}
    //
    //private void back(int[] nums, int start) {
    //    res.add(new ArrayList<>(path));
    //    set.clear();
    //    for (int i = start; i < nums.length; i++) {
    //        if (set.contains(i)) continue;
    //        set.add(i);
    //        path.add(nums[i]);
    //        back(nums, i + 1);
    //        path.remove(path.size() - 1);
    //    }
    //}
}
