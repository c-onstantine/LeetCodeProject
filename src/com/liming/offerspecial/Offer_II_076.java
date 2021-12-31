package com.liming.offerspecial;

import java.util.Random;

/**
 * @author ltf
 * @date 2021-12-31 9:39
 */
public class Offer_II_076 {
    // 队列解法
    //public int findKthLargest(int[] nums, int k) {
    //    PriorityQueue<Integer> queue = new PriorityQueue<>();
    //    for (int num : nums) {
    //        if (queue.size() < k) {
    //            queue.offer(num);
    //        } else {
    //            if (queue.peek() < num) {
    //                queue.poll();
    //                queue.offer(num);
    //            }
    //        }
    //    }
    //    return queue.peek();
    //}

    //    快排解法
    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = partition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int partition(int[] a, int l, int r) {
        // 哨兵初始化。该处的一个优化是，用随机函数选择一个数组下标k，然后swap(a, l, k)
        int rand = random.nextInt(r - l + 1) + l;
        swap(a, l, rand);
        int x = a[l], j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                swap(a, ++j, i);
            }
        }
        swap(a, l, j);
        return j;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
