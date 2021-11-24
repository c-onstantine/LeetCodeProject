package com.liming.tanxin;

/**
 * @author ltf
 * @date 2021-09-09 20:17
 * 134. 加油站
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int total = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (cur < 0) {
                index = i + 1;
                cur = 0;
            }
        }
        if (total < 0) return -1;
        return index;
    }
}
