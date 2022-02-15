package com.liming.hot100;

/**
 * @author ltf
 * @date 2022-02-15 15:48
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Hot_13 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 求左边界
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        //求右边界
        int left1 = 0, right1 = nums.length - 1;
        while (left1 <= right1) {
            int mid = left1 + (right1 - left1 >> 1);
            if (nums[mid] < target) {
                left1 = mid + 1;
            } else if (nums[mid] > target) {
                right1 = mid - 1;
            } else if (nums[mid] == target) {
                left1 = mid + 1;
            }
        }
        return new int[]{left, right1};
    }

    public static void main(String[] args) {
        int[] num = new int[]{};
        new Hot_13().searchRange(num,0);
    }
}
