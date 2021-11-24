package com.liming.interviewclassic;

/**
 * @author ltf
 * @date 2021-06-07 20:39
 * 面试题 16.16. 部分排序
 * 首先虽然题目没说，但是实际运行下来数列是单调递增的，所以我们下面默认数列是递增的。
 * <p>
 * 那么对于元素 a[i] 来说，如果它左边存在大于 a[i] 的元素，那么 a[i] 是一定要参与到排序里去的。或者说如果它右边存在小于 a[i] 的元素，那么 a[i] 也是要参与到排序里去的。
 * <p>
 * 所以我们只需要寻找最靠右的那个数（满足左边存在大于它的数），和最靠左的那个数（满足右边存在小于它的数），那么这两个数之间就是要排序的区间了。
 * <p>
 * 为什么最靠右的那个（满足左边存在大于它的数）数一定能保证右边没有更小的数了呢？因为如果右边还有更小的数，那么那个更小的数才是更靠右的啊，这就矛盾了。
 * <p>
 * 所以我们只需要从左到右扫描一遍，用一个变量维护一下最大值就行了，然后反向再遍历一遍，维护一个最小值。
 */
public class Face1616 {
    public int[] subSort(int[] array) {

        int len = array.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int first = -1, last = -1;
        for (int i = 0; i < len; i++) {
            if (array[i] < max) {
                last = i;
            } else {
                max = array[i];
            }
            if (array[len - i - 1] > min) {
                first = len - i - 1;
            } else {
                min = array[len - i - 1];
            }
        }
        return new int[]{first, last};
    }
}
