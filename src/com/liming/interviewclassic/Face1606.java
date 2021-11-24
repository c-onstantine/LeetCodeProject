package com.liming.interviewclassic;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-05-27 20:58
 */
public class Face1606 {
    public int smallestDifference(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int alen = a.length;
        int blen = b.length;
        Arrays.sort(a);
        Arrays.sort(b);
        int min = Integer.MIN_VALUE;
        while (i < alen && j < blen) {
            min = Math.max(min, -Math.abs(a[i] - b[j]));
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Math.abs(min);
    }
}
