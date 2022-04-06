package com.liming.mid;

/**
 * @author ltf
 * @date 2022-04-05 17:00
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            // 总和都小于0 肯定走不到这里，要从下一个点开始走
            if (cur < 0) {
                cur = 0;
                start = i + 1;
            }
        }
        if (total < 0) return -1;
        return start;
    }
}
