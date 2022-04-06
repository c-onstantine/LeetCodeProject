package com.liming.mid;

/**
 * @author ltf
 * @date 2022-04-06 10:04
 */
public class SumofSquareNum_633 {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int tmp = left * left + right * right;
            if (tmp == c) {
                return true;
            } else if (tmp < c) {
                left++;
            } else if (tmp > c) {
                right--;
            }
        }
        return false;
    }
}
