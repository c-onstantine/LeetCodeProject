package com.liming.interviewclassic;

import java.util.LinkedHashMap;

/**
 * @author ltf
 * @date 2021-06-18 9:07
 */
public class Face1625 {
    private int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public Face1625(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>((int) ((float) capacity / 0.75f + 1.0f), 0.75f, true);
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }
        return value;
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
