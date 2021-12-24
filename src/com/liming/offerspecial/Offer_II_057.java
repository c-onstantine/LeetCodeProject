package com.liming.offerspecial;

import java.util.TreeSet;

/**
 * @author ltf
 * @date 2021-12-24 14:35
 */
public class Offer_II_057 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        Integer small = null;
        Integer big = null;
        for (int i = 0; i < nums.length; i++) {
            small = set.floor(nums[i]);
            if (small != null && (long)small >= (long)nums[i] - t) return true;
            big = set.ceiling(nums[i]);
            if (big != null && (long)big <= (long)nums[i] + t) return true;
            set.add(nums[i]);
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}
