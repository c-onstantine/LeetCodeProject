package com.liming.offerspecial;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-12-07 19:43
 */
public class Offer_II_004 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, -1);
            } else {
                map.put(num, 1);
            }
        }
        return map.entrySet().stream().filter((x) -> x.getValue() == 1).findFirst().get().getKey();
    }
}
