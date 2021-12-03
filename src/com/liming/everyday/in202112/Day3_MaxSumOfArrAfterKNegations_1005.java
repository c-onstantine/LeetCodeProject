package com.liming.everyday.in202112;

/**
 * @author ltf
 * @date 2021-12-03 16:34
 * 1005. K 次取反后最大化的数组和
 * 最小值取相反数
 */
public class Day3_MaxSumOfArrAfterKNegations_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //数据范围在-100 到 100  因此可以做一个映射
        int[] map = new int[201];
        for (int num : nums) {
            map[num + 100]++;
        }
        int index = 0;
        while (k > 0) {
            while (map[index] == 0) index++; // 找最小值的过程，最小值就是第一次出现的那个值
            map[index]--; // 变相反数
            map[200 - index]++;
            if (index > 100) {  //原本最小值是正的话 就把下标改成它相反数的位置 也就是此时 最小值是负数了
                index = 200 - index;
            }
            k--;
        }
        int res = 0;
        for (int j = index; j < map.length; j++) {
            res += (j - 100) * map[j];
        }
        return res;
    }
}
