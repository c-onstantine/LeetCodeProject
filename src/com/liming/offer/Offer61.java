package com.liming.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ltf
 * @date 2021-04-06 15:13
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (tmp.contains(num)) return false;
            tmp.add(num);
        }
        return max - min < 5;
    }
//    public boolean isStraight(int[] nums) {
//        if (nums == null || nums.length < 5) return false;
//        Arrays.sort(nums);
//        int count0 = 0;
//        int index = 0;
//        int not0 = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                count0++;
//            } else {
//                index = i;
//                not0 = nums[i];
//                break;
//            }
//        }
//
//        for (int i = index; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i + 1]) {
//                return false;
//            }
//        }
//        boolean flag = true;
//        int cmp = 0;
//        for (int i = index; i < nums.length; i++) {
//            if (not0 + cmp == nums[i]) {
//                cmp++;
//            } else {
//                if (count0 > 0) {
//                    cmp++;
//                    count0--;
//                    i--;
//                } else {
//                    flag = false;
//                    break;
//                }
//            }
//        }
//        return flag;
//    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 5};
        new Offer61().isStraight(nums);
    }
}
