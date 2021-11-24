package com.liming.movewindow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author ltf
 * @date 2021-11-16 11:40
 * 220. 存在重复元素 III
 */
public class ContainsDuplicate_III220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> tset = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long l = tset.floor(nums[i] * 1L);
            Long r = tset.ceiling(nums[i] * 1L);
            if ((l != null && nums[i] - l <= t) || (r != null && r - nums[i] <= t)) return true;
            tset.add(nums[i] * 1L);
            if (i >= k) tset.remove(nums[i - k]*1L);
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }
        Iterator<String> iterator = list.iterator();
        int i = 0 ;
        while(iterator.hasNext()) {
            if (i == 3) {
                list.remove(3);
            }
            System.out.println(iterator.next());
            i ++;
        }
    }
}
