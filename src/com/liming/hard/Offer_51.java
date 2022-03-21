package com.liming.hard;

/**
 * @author ltf
 * @date 2022-03-14 15:09
 */
public class Offer_51 {
    private int res;

    public int reversePairs(int[] nums) {
        res = 0;
        mergeSort(nums,0,nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        sort(nums, left, mid, right);
    }

    private void sort(int[] nums, int left, int mid, int right) {
        int rstart = mid + 1;
        int[] tmp = new int[right - left + 1];
        int l = left;
        int index = 0;
        while (l <= mid && rstart <= right) {
            if (nums[l] <= nums[rstart]) {
                tmp[index++] = nums[l++];
            } else {
                res += (mid - l + 1);
                tmp[index++] = nums[rstart++];
            }
        }
        while (l <= mid) {
            tmp[index++] = nums[l++];
        }
        while (rstart <= right) {
            tmp[index++] = nums[rstart++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[i + left] = tmp[i];
        }
    }
}
