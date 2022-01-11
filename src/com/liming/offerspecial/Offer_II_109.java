package com.liming.offerspecial;

import java.util.*;

/**
 * @author ltf
 * @date 2022-01-11 11:37
 */
public class Offer_II_109 {
    public int openLock(String[] deadends, String target) {
        //用双向广度优先遍历方法，哈希集合代替队列，因为哈希集合判断一个节点是否访问过只需要O(1)的时间，整个算法可大幅提升时间复杂度
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (target.equals("0000")) return 0;
        if (dead.contains("0000") || dead.contains(target)) return -1;
        //起始节点集合
        Set<String> set1 = new HashSet<>();
        //目标节点集合
        Set<String> set2 = new HashSet<>();
        set1.add("0000");
        set2.add(target);
        Set<String> vis = new HashSet<>();//记录已经访问(到达)过的邻居
        vis.add("0000");
        int len = 1;
        //双向遍历可以避免访问很多不满足条件的节点从而大幅提高搜索效率
        while (!set1.isEmpty() && !set2.isEmpty()) {
            //我们要保证从节点较小的那个集合开始广度遍历，这里固定从set1开始
            if (set1.size() > set2.size()) {
                Set<String> tmp = set1;
                set1 = set2;
                set2 = tmp;
            }
            //set3用来保存set1一趟遍历的“邻居”
            Set<String> set3 = new HashSet<>();
            for (String s : set1) {
                List<String> neighbors = getNeighbors(s);
                for (String neighbor : neighbors) {
                    //如果邻居属于死亡节点，直接跳过
                    if (dead.contains(neighbor)) continue;
                    //如果本次遍历的邻居就是目标节点，则找到一条从起始到目标节点的最短路径
                    if (set2.contains(neighbor)) return len;
                    //如果本次遍历的“邻居”未曾到达，把它加进邻居集合里并标记已访问
                    if (!vis.contains(neighbor)) {
                        set3.add(neighbor);
                        vis.add(neighbor);
                    }
                }
            }
            //到这里说明通过一趟遍历没有找到一条路径，就把路径长度+1，同时把本趟邻居集合当作下一趟开始遍历的起始节点集合
            len++;
            set1 = set3;
        }
        return -1;
    }

    //求传入的字符串“邻居”集合
    public List<String> getNeighbors(String s) {
        List<String> ls = new LinkedList<>();
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < ch.length; ++i) {
            char old = ch[i];
            ch[i] = ch[i] == '0' ? '9' : (char) (ch[i] - 1);
            sb.setCharAt(i, ch[i]);
            ls.add(sb.toString());
            sb.setCharAt(i, old);
            ch[i] = old;
            ch[i] = ch[i] == '9' ? '0' : (char) (ch[i] + 1);
            sb.setCharAt(i, ch[i]);
            ls.add(sb.toString());
            sb.setCharAt(i, old);
            ch[i] = old;
        }
        return ls;
    }
}
