package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-05-17 21:38
 */
public class Face1003 {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (target == arr[left])
                return left;
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid;
            } else if (arr[mid] > arr[right]) {
                if (target < arr[mid] && target >= arr[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < arr[right]) {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                right--;
            }
        }
        return -1;
    }
}
