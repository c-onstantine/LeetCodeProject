package com.liming.offerspecial;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author ltf
 * @date 2021-12-24 15:08
 */
public class Offer_II_058 {
    private TreeMap<Integer, Integer> events;

    public Offer_II_058() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> event = events.ceilingEntry(start);
        // 与后一个时间段重叠
        if (event != null && event.getKey() < end) {
            return false;
        }
        event = events.floorEntry(start);
        // 与前一个时间段重叠
        if (event != null && event.getValue() > start) {
            return false;
        }
        events.put(start, end);
        return true;
    }

}
