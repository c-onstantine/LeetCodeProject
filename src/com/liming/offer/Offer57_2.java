package com.liming.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-03-30 20:37
 */
public class Offer57_2 {
    public int[][] findContinuousSequence(int target) {
        if (target < 3) return new int[0][0];
        List<int[]> res = new ArrayList<>();
        int mid = (1 + target) / 2;
        int i = 1;
        int j = 2;
        int cur = i + j;
        while (i < mid) {
            if (cur == target) {
                int[] tmp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    tmp[k - i] = k;
                }
                res.add(tmp);
            }
            if (cur > target) {
                cur -= i;
                i++;
            } else {
                j++;
                cur += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
