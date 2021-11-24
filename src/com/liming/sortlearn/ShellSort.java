package com.liming.sortlearn;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-02-09 11:40
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(nums);
        System.out.println("最终排序结果:" + Arrays.toString(nums));
    }

    private static void sheelSort2(int[] nums) {
        int tmp = 0;
        int n = nums.length;
        int count = 0;
        // 对数组进行分组
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                // 遍历各组中所有元素（共gap组，每组个元素），不长是gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 当前元素大于加上步长后的那个元素，说明交换
                    if (nums[j] > nums[j + gap]) {
                        tmp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = tmp;
                    }
                }
            }
            System.out.println("第" + (++count) + "轮希尔排序中间结果：" + Arrays.toString(nums));
        }
    }

    private static void shellSort(int[] nums) {
        int n = nums.length;
        int count=0;
        // 分组区间 range  需要逐步缩小这个range 分组逐渐变少 整个数组逐渐有序
        for (int range = n / 2; range > 0; range /= 2) {
            for (int i = range; i < n; i++) {
                int j = i;
                int tmp = nums[j];
                if (nums[j] < nums[j - range]) {
                    while (j - range >= 0 && tmp < nums[j - range]) {
                        nums[j] = nums[j - range];
                        j -= range;
                    }
                    nums[j] = tmp;
                }
            }
            System.out.println("第" + (++count) + "轮希尔排序中间结果：" + Arrays.toString(nums));
        }
    }
}
