package com.liming.mid;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2022-03-23 10:22
 * 321. 拼接最大数
 * 单调栈 +  分治合并
 */
public class CreateMaxNumber_321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[0];
        for (int i = 0; i <= k && i < nums1.length; i++) {
            if (k - i >= 0 && k - i < nums2.length) {
                int[] tmp = merge(maxSub(nums1, i), maxSub(nums2, k - i));
                if (compare(tmp, 0, res, 0)) {
                    res = tmp;
                }
            }
        }
        return res;
    }
    private int[] maxSub(int[] nums, int k) {
        int realK = nums.length - k;
        Deque<Integer> stack = new LinkedList<>();
        for (int num : nums) {
            while (realK > 0 && !stack.isEmpty() && stack.peekLast() < num) {
                realK--;
                stack.pollLast();
            }
            if (num != 0 || !stack.isEmpty()) {
                stack.offerLast(num);
            }
        }
        while (realK > 0 && !stack.isEmpty()) {
            realK--;
            stack.pollLast();
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pollFirst();
        }
        return res;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int index = 0, p1 = 0, p2 = 0;
        while (index < nums1.length + nums2.length) {
            if (compare(nums1, p1, nums2, p2)) {
                res[index++] = nums1[p1++];
            } else {
                res[index++] = nums2[p2++];
            }
        }
        return res;
    }

    private boolean compare(int[] nums1, int p1, int[] nums2, int p2) {
        if (p2 >= nums2.length) return true;
        if (p1 >= nums1.length) return false;
        if (nums1[p1] > nums2[p2]) return true;
        if (nums1[p1] < nums2[p2]) return false;
        return compare(nums1, p1 + 1, nums2, p2 + 1);
    }
}
