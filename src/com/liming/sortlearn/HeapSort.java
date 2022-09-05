package com.liming.sortlearn;

import java.util.Arrays;

/**
 * @author ltf
 * @date 2022-03-30 9:16
 * 堆排序 不稳定
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {100, 25, 120, 1};
        Arrays.stream(arr).mapToObj(x -> x + " " ).forEach(System.out::print);
        System.out.println("");
        heapSort(arr);
        System.out.println("排序后");
        Arrays.stream(arr).mapToObj(x -> x + " " ).forEach(System.out::print);
    }

    private static void heapSort(int[] arr) {
        for(int i = arr.length / 2; i >=0; i--){
            headAdjust(arr,i,arr.length);
        }
        //把每个最大值 和数组最后一个交换 并调整剩余元素 保持最大堆 最终形成升序数组。
        for(int i = arr.length - 1; i > 0; i--){
            swap(arr,0,i);
            headAdjust(arr,0,i); // 0 到 i - 1 调整
        }
    }

    private static void headAdjust(int[] arr, int i, int n) {
        int childIndex = 0;
        int father;
        for (father = arr[i]; getLeftChildIndex(i) < n; i = childIndex) {
            childIndex = getLeftChildIndex(i);
            // 找到左右孩子较大的一个 和父节点比较 不满足大根堆则交换
            if (childIndex < n - 1 && arr[childIndex] < arr[childIndex + 1]) {
                childIndex++; // 右孩子大 则下标指向右节点
            }
            // 不满足则交换 继续循环
            if (father < arr[childIndex]) {
                arr[i] = arr[childIndex];
            } else {
                break;
            }
        }
        arr[i] = father;
    }

    private static int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
