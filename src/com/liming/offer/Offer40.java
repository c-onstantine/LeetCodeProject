package com.liming.offer;

import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2021-03-19 15:44
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        PriorityQueue<Integer> heep = new PriorityQueue<Integer>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            heep.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (heep.peek() > arr[i]) {
                heep.poll();
                heep.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heep.poll();
        }
        return res;
    }
}
