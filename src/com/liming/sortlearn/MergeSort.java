package com.liming.sortlearn;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-02-22 15:17
 * 稳定
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {8, 4, 5, 7, 1, 3, 6, 2};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int l1 = mid + 1;
        int[] tmp = new int[nums.length];
        int tmpindex = left;
        int realindex = left;
        while (left <= mid && l1 <= right) {
            if (nums[left] <= nums[l1]) {
                tmp[tmpindex++] = nums[left++];
            } else {
                tmp[tmpindex++] = nums[l1++];
            }
        }
        while (left <= mid) {
            tmp[tmpindex++] = nums[left++];
        }
        while (l1 <= right) {
            tmp[tmpindex++] = nums[l1++];
        }
        while (realindex <= right) {
            nums[realindex] = tmp[realindex];
            realindex++;
        }
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);

    }
}
