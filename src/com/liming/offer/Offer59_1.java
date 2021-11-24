package com.liming.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-03-31 16:11
 */
public class Offer59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) { // 比新插入的元素 如果最后一个比它小 那么最后一个可以丢掉 不影响计算最大值。
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) { //移除窗口的值 正好是最大值 那么需要维护这个队列 因此移除最大值
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
