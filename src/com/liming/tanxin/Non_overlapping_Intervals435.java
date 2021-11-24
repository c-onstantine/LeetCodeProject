package com.liming.tanxin;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-01-21 10:12
 */
public class Non_overlapping_Intervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n==0){
            return 0;
        }
        Arrays.sort(intervals,(int[] a,int[] b)->{
            if(a[1]<b[1]){
                return -1;
            }else if (a[1]>b[1]){
                return 1;
            }else{
                return 0;
            }
        });

        int count =1;
        int end=intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if(start>=end){
                count++;
                end=interval[1];
            }
        }

        return n-count;
    }
}
