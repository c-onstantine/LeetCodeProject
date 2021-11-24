package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-23 17:59
 */
public class Offer53_1 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int index = erfen(nums, 0, nums.length - 1, target);
        int pre = index - 1, next = index + 1;
        int count = 0;
        if(index != -1){
            count++;
        }
        while (pre >= 0 && nums[pre] == target) {
            pre--;
            count++;
        }
        while (next <= nums.length - 1 && nums[next] == target) {
            next++;
            count++;
        }
        return count;
    }

    private int erfen(int[] nums, int start, int end, int tar) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        int index = -1;
        if (nums[mid] > tar) {
            index = erfen(nums, start, mid - 1, tar);
        } else if (nums[mid] < tar) {
            index = erfen(nums, mid + 1, end, tar);
        } else {
            index = mid;
        }
        return index;
    }


}
