package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ltf
 * @date 2021-12-25 10:54
 */
public class Offer_II_061 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((x, y) -> {
            return Integer.compare(y.get(0) + y.get(1), x.get(0) + x.get(1));
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (queue.size() < k) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums1[i]);
                    tmp.add(nums2[j]);
                    queue.offer(tmp);
                } else {
                    List<Integer> peek = queue.peek();
                    if (peek.get(0) + peek.get(1) > nums1[i] + nums2[j]) {
                        queue.poll();
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums1[i]);
                        tmp.add(nums2[j]);
                        queue.offer(tmp);
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) break;
            res.add(queue.poll());
        }
        return res;
    }
}
