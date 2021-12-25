package com.liming.offerspecial;

import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2021-12-25 9:57
 */
public class Offer_II_059 {
    private PriorityQueue<Integer> queue;
    private int size;

    public Offer_II_059(int k, int[] nums) {
        queue = new PriorityQueue<>();
        size = k;
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if (queue.size() < size) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
