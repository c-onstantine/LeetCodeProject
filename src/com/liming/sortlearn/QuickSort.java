package com.liming.sortlearn;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ltf
 * @date 2021-02-15 9:27
 */
public class QuickSort {
    private static Random random  = new Random();
    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        quickSort1(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int tmp = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= tmp) j--;
            while (i < j && nums[i] <= tmp) i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // 走到这里说明i=j,需要把基准值与i或j交换位置。 这时基准值的左边都比他小，右边都比他大。
        nums[left] = nums[i];
        nums[i] = tmp;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
    private static void quickSort1(int[] nums,int left,int right){
        if(left > right) return;
        int index = left + random.nextInt(right - left + 1);
        swap(nums,index,right);
        int l = left;
        for(int i = left; i < right; i++){
            if(nums[i] < nums[right]){
                swap(nums,l,i);
                l++;
            }
        }
        swap(nums,l,right);
        quickSort(nums,left,l-1);
        quickSort(nums,l+1,right);
    }
    private static void swap(int[] nums, int x,int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
