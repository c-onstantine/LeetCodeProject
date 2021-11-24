package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-11-01 21:22
 * 169. 多数元素 简单
 */
public class MajorityElement_169 {
    // 排序法 垃圾
    //public int majorityElement(int[] nums) {
    //    Arrays.sort(nums);
    //    return nums[nums.length / 2];
    //}
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count = 1;
            } else if (res == nums[i]) {
                count++;
            } else if (res != nums[i]) {
                count--;
            }
        }
        return res;
    }
}
