package com.liming.huawei.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ltf
 * @date 2022-04-08 11:15
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                System.out.println(num);
                return;
            }
            set.add(num);
        }
        System.out.println("不存在");
    }
}
