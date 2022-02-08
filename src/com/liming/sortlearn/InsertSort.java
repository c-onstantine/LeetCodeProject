package com.liming.sortlearn;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-02-09 9:25
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {130, 35, 109, 1};
        insertSort(nums);
        System.out.println("最终结果:" + Arrays.toString(nums));

    }

    private static void insertSort(int[] nums) {
        int n = nums.length;
        int indexval = 0; //当前要插入节点值
        int preindex = 0; //当前要插入节点的前一个节点
        for (int i = 1; i < n; i++) {
            indexval = nums[i];
            preindex = i - 1;
            while (preindex >= 0 && nums[preindex] > indexval) {
                nums[preindex + 1] = nums[preindex];
                preindex--;
            }
            nums[preindex + 1] = indexval;
            System.out.println("第" + i + "次插入");
            System.out.println(Arrays.toString(nums));
        }
    }
}
