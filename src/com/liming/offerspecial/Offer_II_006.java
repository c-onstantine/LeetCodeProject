package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-07 20:18
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * 双指针法
 */
public class Offer_II_006 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[0];
    }
}

