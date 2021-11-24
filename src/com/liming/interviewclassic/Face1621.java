package com.liming.interviewclassic;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-06-16 19:12
 */
public class Face1621 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int s1 = Arrays.stream(array1).sum();
        int s2 = Arrays.stream(array2).sum();
        int diff = s1 - s2;
        if ((diff & 1) == 1) {
            return new int[]{};
        }
        int i = 0, j = 0;
        Arrays.sort(array1);
        Arrays.sort(array2);
        while (i < array1.length && j < array2.length) {
            if ((array1[i] - array2[j]) * 2 == diff) {
                return new int[]{array1[i], array2[j]};
            } else if ((array1[i] - array2[j]) * 2 < diff) {
                i++;
            } else {
                j++;
            }
        }
        return new int[]{};
    }
}
