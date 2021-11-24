package com.liming.interviewclassic;

import java.util.*;

/**
 * @author ltf
 * @date 2021-06-17 21:14
 * 面试题 16.24. 数对和
 */
public class Face1624 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res.add(Arrays.asList(nums[left++], nums[right--]));
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("a","A");
        map.put("b","B");
        String v = map.putIfAbsent("b","v");  // 输出 B
        System.out.println(v);
        String v1 = map.putIfAbsent("c","v");  // 输出 null
        System.out.println(v1);
        System.out.println(map.computeIfAbsent("c", k -> {
            System.out.println("---");
            return "c";
        }));
        System.out.println(map);
    }
}
