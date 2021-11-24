package com.liming.interviewclassic;

import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2021-06-25 13:17
 * 面试题 17.14. 最小K个数 直接小根堆
 * 可以借助快排划分
 */
public class Face1714 {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1);
        for (int i : arr) {
            queue.offer(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
