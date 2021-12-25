package com.liming.offerspecial;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2021-12-25 10:27
 */
public class Offer_II_060 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {
            return x[1] - y[1];
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
