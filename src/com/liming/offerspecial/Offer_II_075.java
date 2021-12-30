package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-30 19:13剑指 Offer II 075. 数组相对排序
 * 数组最大元素1000 因此可以通过定义一个大数组来计数
 */
public class Offer_II_075 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1) {
            count[i]++;
        }
        int index = 0;
        for (int i : arr2) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        return arr1;
    }
}
