package com.liming.offerspecial;

import java.util.*;

/**
 * @author ltf
 * @date 2021-12-15 21:02
 * 集合中没有重复元素 因此map可以val存值的下标
 */
public class Offer_II_030 {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public Offer_II_030() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());  // 值对应的下标
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastnum = list.get(list.size() - 1);
        map.put(lastnum, index); // 相当于用最后一个数 顶替了要删除的数
        list.set(index, lastnum);
        map.remove(val);
        list.remove(list.size() - 1);// 这样remove方法就是o1  不需要移动数组
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
