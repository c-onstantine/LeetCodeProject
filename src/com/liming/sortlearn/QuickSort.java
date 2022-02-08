package com.liming.sortlearn;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-02-15 9:27
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int tmp = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= tmp) j--;
            while (i < j && nums[i] <= tmp) i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // 走到这里说明i=j,需要把基准值与i或j交换位置。 这时基准值的左边都比他小，右边都比他大。
        nums[left] = nums[i];
        nums[i] = tmp;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}
