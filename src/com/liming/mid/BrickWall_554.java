package com.liming.mid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ltf
 * @date 2022-04-07 15:51
 */
public class BrickWall_554 {
    public int leastBricks(List<List<Integer>> wall) {
        int size = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int wide : wall.get(i)) {
                sum += wide;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            //去掉最后贴墙的缝
            map.remove(sum);
            sum = 0; // 置0 下一层砖重新遍历
        }
        int ans = size;
        for (int key : map.keySet()) {
            ans = Math.min(ans, size - map.get(key));
        }
        return ans;
    }
}
