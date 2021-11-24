package com.liming.offeragain;

/**
 * @author ltf
 * @date 2021-11-09 17:07
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class Offer_11 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]) {
                j = mid;
            } else {
                j--;
            }
        }
        return numbers[i];
    }
}
