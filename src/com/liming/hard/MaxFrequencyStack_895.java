package com.liming.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author ltf
 * @date 2022-03-25 16:08
 */
public class MaxFrequencyStack_895 {
    private HashMap<Integer,Integer> map = new HashMap<>();
    private HashMap<Integer, Deque<Integer>> freq = new HashMap<>();
    private int maxfreq = 0;
    public MaxFrequencyStack_895() {

    }

    public void push(int val) {
        int f = map.getOrDefault(val,0) + 1;
        map.put(val,f);
        if(f > maxfreq){
            maxfreq = f;
        }
        freq.computeIfAbsent(f,(x)->new ArrayDeque<>()).offerFirst(val);
    }

    public int pop() {
        int res = freq.get(maxfreq).pollFirst();
        map.put(res,map.get(res) - 1);
        if(freq.get(maxfreq).size() == 0){
            maxfreq--;
        }
        return res;
    }
}
