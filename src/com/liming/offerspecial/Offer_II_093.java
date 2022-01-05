package com.liming.offerspecial;

import java.util.HashMap;

/**
 * @author ltf
 * @date 2022-01-05 20:07
 */
public class Offer_II_093 {
    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];   // 以i为序列结尾，前一个数是j序列长度
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);  // 值和下标对应
        }
        int ret = 0;
        int tmp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                tmp = arr[i] - arr[j];
                if (map.containsKey(tmp) && map.get(tmp) < j) {
                    dp[i][j] = dp[j][map.get(tmp)] + 1;
                } else {
                    dp[i][j] = 2;
                }
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret > 2 ? ret : 0;
    }
}
