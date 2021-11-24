package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-10-10 17:19
 * 88. 合并两个有序数组
 */
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m - 1;
        int l2 = n - 1;
        int len = nums1.length - 1;
        while (l1 >= 0 && l2 >= 0) {
            nums1[len--] = nums1[l1] > nums2[l2] ? nums1[l1--] : nums2[l2--];
        }
        if (l2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, l2 + 1);
        }
    }
}
