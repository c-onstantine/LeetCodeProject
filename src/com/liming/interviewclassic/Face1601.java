package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-24 18:50
 * 面试题 16.01. 交换数字
 */
public class Face1601 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}
