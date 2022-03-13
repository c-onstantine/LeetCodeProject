package com.liming.microsoft;

/**
 * @author ltf
 * @date 2022-03-06 13:48
 */
public class MergeSort {
    public static void main(String[] args) {
        new MergeSort().sortArray(new int[]{5, 2, 3, 1});
    }

    public int[] sortArray(int[] nums) {
        megreSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void megreSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        megreSort(nums, start, mid);
        megreSort(nums, mid + 1, end);
        megre(nums, start, mid, end);
    }

    private void megre(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int rstart = mid + 1;
        int index = 0;
        int l = start, r = end;
        while (start <= mid && rstart <= end) {
            if (nums[start] > nums[rstart]) {
                tmp[index++] = nums[rstart++];
            } else {
                tmp[index++] = nums[start++];
            }
        }
        while (start <= mid) {
            tmp[index++] = nums[start++];
        }
        while (rstart <= end) {
            tmp[index++] = nums[mid++];
        }
        for (int i = l; i <= r; i++) {
            nums[i] = tmp[i - l];
        }
    }
}
