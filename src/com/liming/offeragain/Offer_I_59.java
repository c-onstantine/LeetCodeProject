package com.liming.offeragain;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-12-01 19:22
 */
public class Offer_I_59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        //初始化窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.pollLast();
            deque.offerLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        //开始滑动
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.pollLast();
            deque.offerLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
