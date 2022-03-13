package com.liming.movewindow;

import java.util.HashSet;

/**
 * @author ltf
 * @date 2021-11-16 11:13
 * 219. 存在重复元素 II
 */
public class ContainsDuplicate_II219{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
