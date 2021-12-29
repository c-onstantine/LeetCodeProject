package com.liming.offerspecial;

import java.util.Random;

/**
 * @author ltf
 * @date 2021-12-29 19:26
 * 剑指 Offer II 071. 按权重生成随机数
 * 前缀加二分查找
 */
public class Offer_II_071 {
    private int[] presum;
    private Random random;
    public Offer_II_071(int[] w) {
        random = new Random();
        for(int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.presum=w;
    }

    public int pickIndex() {
        int r = random.nextInt(presum[presum.length - 1]) + 1;
        int left = 0;
        int right = presum.length,mid = 0;
        while(left < right) {
            mid = left + (right - left)/2;
            if(presum[mid] >= r) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
