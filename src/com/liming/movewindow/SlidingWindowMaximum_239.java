package com.liming.movewindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ltf
 * @date 2022-02-28 14:14
 */
public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        new SlidingWindowMaximum_239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        // 队首始终保存当前窗口的最大值
        Deque<Integer> queue = new LinkedList<>();
        while (right < nums.length) {
            while (!queue.isEmpty() && queue.peekLast() < nums[right]) {
                queue.pollLast();
            }
            queue.offerLast(nums[right]);
            right++;
            if (right >= k) {
                res[left++] = queue.peekFirst();
                if (queue.peekFirst() == nums[right - k]) {
                    queue.pollFirst();
                }
            }
        }
        return res;
    }
}
