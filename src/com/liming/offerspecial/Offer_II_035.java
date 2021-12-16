package com.liming.offerspecial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ltf
 * @date 2021-12-16 20:08
 */
public class Offer_II_035 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) return 0; // 时间最多有24*60中组合，如果超过这个 则一定有一样的时间 所有差值为0
        List<Integer> minutes = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] strarr = timePoint.split(":");
            minutes.add(Integer.valueOf(strarr[0]) * 60 + Integer.valueOf(strarr[1]));
        }
        Collections.sort(minutes); // 排序时间
        int res = 24 * 60;
        minutes.add(minutes.get(0) + res); // 处理差值 是最大值和最小值差的情况
        for (int i = 1; i < minutes.size(); i++) {
            res = Math.min(res, minutes.get(i) - minutes.get(i - 1));
        }
        return res;
    }
}
