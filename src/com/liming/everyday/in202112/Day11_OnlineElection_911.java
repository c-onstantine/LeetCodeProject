package com.liming.everyday.in202112;

import java.util.*;

/**
 * @author ltf
 * @date 2021-12-13 18:05
 */
public class Day11_OnlineElection_911 {
    private List<int[]> list = new ArrayList<>();

    public Day11_OnlineElection_911(int[] persons, int[] times) {
        Map<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for (int i = 0; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (val <= map.get(persons[i])) { // 保证平局时最近获得投票的人也在list中
                val = map.get(persons[i]);
                list.add(new int[]{times[i], persons[i]});
            }
        }
    }

    public int q(int t) {
        int l = 0, r = list.size() - 1, mid = 0;
        while (l < r) {
            mid = l + r + 1 >> 1;
            if (list.get(mid)[0] <= t) {  //获取最右边界
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return list.get(r)[0] <= t ? list.get(r)[1] : 0;
    }
}
