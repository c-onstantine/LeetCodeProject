package com.liming.easy;

/**
 * @author ltf
 * @date 2021-08-23 9:43
 * 1646. 获取生成数组中的最大值
 */
public class GetMaximuminGeneratedArray_1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] num = new int[n + 1];
        num[0] = 0;
        num[1] = 1;
        int max = 1;
        int index = 1;
        while ((index * 2 + 1) <= n) {
            num[index * 2] = num[index];
            num[index * 2 + 1] = num[index] + num[index + 1];
            max = Math.max(max, Math.max(num[index * 2], num[index * 2 + 1]));
            index++;
        }
        if (index * 2 <= n) {
            num[index * 2] = num[index];
            max = Math.max(max, num[index * 2]);
        }

        return max;
    }
}
