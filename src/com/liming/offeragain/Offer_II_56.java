package com.liming.offeragain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-11-27 13:45
 * 笨方法 hashmap
 */
public class Offer_II_56 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, -1);
            } else {
                map.put(num, 1);
            }
        }
        Integer res = map.entrySet().stream().filter((x) -> x.getValue().equals(1)).map((x) -> x.getKey()).findFirst().get();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer_II_56().singleNumber(new int[]{3, 4, 3, 3}));
    }
}
