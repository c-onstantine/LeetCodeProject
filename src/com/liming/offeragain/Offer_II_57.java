package com.liming.offeragain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltf
 * @date 2021-11-29 20:10
 */
public class Offer_II_57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int sum = 0;
        int i = 1;
        int j = 1;
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] tmp = new int[j - i];
                for (int k = i; k < j; k++) {
                    tmp[k - i] = k;
                }
                res.add(tmp);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
