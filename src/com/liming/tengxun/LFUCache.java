package com.liming.tengxun;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author ltf
 * @date 2022-02-20 10:04
 */
public class LFUCache {
    private int capacity;
    private int time;
    private Map<Integer, Node> map;
    private TreeSet<Node> set;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
        map = new HashMap<>();
        set = new TreeSet<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (map.containsKey(key)) {
            Node cache = map.get(key);
            set.remove(cache);
            cache.count += 1;
            cache.time = ++time;
            set.add(cache);
            return cache.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            set.remove(node);
            node.count += 1;
            node.time = ++time;
            node.value = value;
            map.put(key, node);
            set.add(node);
        } else {
            if (map.size() == capacity) {
                map.remove(set.first().key);
                set.remove(set.first());
            }
            Node node = new Node(1, ++time, key, value);
            set.add(node);
            map.put(key, node);
        }
    }


    private class Node implements Comparable<Node> {
        private int count;  // 频率
        private int time;   // 最近使用时间
        private int key;
        private int value;

        public Node() {
        }

        public Node(int count, int time, int key, int value) {
            this.count = count;
            this.time = time;
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.count == o.count ? this.time - o.time : this.count - o.count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key &&
                    value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }


}
