package com.liming.sortlearn;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-02-08 14:49
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {100, 25, 120, 1};
        selectSort(nums);
        System.out.println("最终结果:" + Arrays.toString(nums));
    }

    private static void selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i; //每次循环初始化的最小值是 当前处理序列的第一个元素
            int min = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (min > nums[j]) {
                    index = j;
                    min = nums[j];
                }
            }
            if (index != i) { //最小值不是初始值的时候才交换 否则不用交换  一趟下来 选择最小值
                nums[index] = nums[i];
                nums[i] = min;
            }
            System.out.println("第" + (i + 1) + "次循环");
            System.out.println(Arrays.toString(nums));
        }
    }
}
