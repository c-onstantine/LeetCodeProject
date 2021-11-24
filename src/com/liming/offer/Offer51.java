package com.liming.offer;

/**
 * @author ltf
 * @date 2021-03-23 16:43
 */
public class Offer51 {
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        int count = digui(nums, copy, 0, nums.length - 1);
        return count;
    }

    private int digui(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int len = (end - start) / 2;
        int left = digui(data, copy, start, start + len);
        int right = digui(data, copy, start + len + 1, end);
        int i = start + len;
        int j = end;
        int copyindex = end;
        int count = 0;
        while (i >= start && j >= start + len + 1) {
            if (data[i] > data[j]) {
                copy[copyindex--] = data[i--];
                count += (j - start - len);
            } else {
                copy[copyindex--] = data[j--];
            }
        }
        for (; i >= start; --i) {
            copy[copyindex--] = data[i];
        }
        for (; j >= start + len + 1; --j) {
            copy[copyindex--] = data[j];
        }
        return left + right + count;
    }
}
