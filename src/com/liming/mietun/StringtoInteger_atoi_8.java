package com.liming.mietun;

/**
 * @author ltf
 * @date 2021-11-04 21:27
 */
public class StringtoInteger_atoi_8 {
    public int myAtoi(String s) {
        int len = s.length();
        char[] nums = s.toCharArray();
        int index = 0;
        while (index < len && nums[index] == ' ') {
            index++;
        }
        if (index == len) return 0;
        int sign = 1;
        if (nums[index] == '+') {
            index++;
        } else if (nums[index] == '-') {
            index++;
            sign = -1;
        }
        int res = 0, last = 0, tmp = 0;
        while (index < len) {
            if (nums[index] < '0' || nums[index] > '9') {
                break;
            }
            tmp = nums[index] - '0';
            last = res;
            res = res * 10 + tmp;
            index++;
            if (res / 10 != last) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return res * sign;
    }
}
