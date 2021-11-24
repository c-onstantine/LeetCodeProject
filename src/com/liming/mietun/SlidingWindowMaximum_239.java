package com.liming.mietun;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2021-10-27 21:51
 * 239. 滑动窗口最大值
 */
public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int left = 0;
        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[right] > nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.offer(right);
            left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
