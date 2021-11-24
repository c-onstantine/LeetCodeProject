package com.liming.offeragain;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2021-11-21 19:43
 * 剑指 Offer 40. 最小的k个数
 */
public class Offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[l] <= arr[j]) j--;
            while (i < j && arr[l] >= arr[i]) i++;
            swap(arr, i, j);

        }
        swap(arr, i, l);
        if (k < i) return quickSort(arr, k, l, i - 1);
        if (k > i) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
