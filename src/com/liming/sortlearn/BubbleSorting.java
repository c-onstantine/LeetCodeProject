package com.liming.sortlearn;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-02-08 12:32
 * 冒泡 稳定排序
 */
public class BubbleSorting {
    public static void main(String[] args) {
        int[] nums = {3, -1, 7, 9, -2};
        BubbleSort(nums);
        System.out.println("final" + Arrays.toString(nums));
    }

    private static void BubbleSort(int[] nums) {
        int n = nums.length;
        int tmp = 0; // 元素交换中间变量
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println("第" + (i + 1) + "次排序");
            System.out.println(Arrays.toString(nums));
        }
    }
}
