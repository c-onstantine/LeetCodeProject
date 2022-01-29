package com.liming.zijie;

/**
 * @author ltf
 * @date 2021-09-13 20:50
 * 哈希表加双向链表
 */
//class LRUCache {
//    private Map<Integer, DLinkedNode> map;
//    private int capacity;
//    private DLinkedNode head;
//    private DLinkedNode tail;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<>();
//        head = new DLinkedNode();
//        tail = new DLinkedNode();
//        head.next = tail;
//        tail.pre = head;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            DLinkedNode node = map.get(key);
//            moveToHead(node);
//            return node.value;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            DLinkedNode node = map.get(key);
//            node.value = value;
//            moveToHead(node);
//        } else {
//            if (map.size() == capacity) {
//                map.remove(tail.pre.key); // 删除最久未使用
//                removeNode(tail.pre);
//            }
//            DLinkedNode node = new DLinkedNode(key, value);
//            map.put(key, node);
//            addToHead(node);
//        }
//    }
//
//    private class DLinkedNode {
//        private int key;
//        private int value;
//        private DLinkedNode pre;
//        private DLinkedNode next;
//
//        public DLinkedNode() {
//
//        }
//
//        public DLinkedNode(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    private void addToHead(DLinkedNode node) {
//        node.pre = head;
//        node.next = head.next;
//        head.next.pre = node;
//        head.next = node;
//    }
//
//    private void removeNode(DLinkedNode node) {
//        node.pre.next = node.next;
//        node.next.pre = node.pre;
//    }
//
//    private void moveToHead(DLinkedNode node) {
//        removeNode(node);
//        addToHead(node);
//    }
//}


import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {
    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            DLinkNode node = cache.get(key);
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (size == capacity) {
                DLinkNode node = removeTail();
                cache.remove(node.key);
                size--;
            }
            DLinkNode newnode = new DLinkNode(key, value);
            cache.put(key, newnode);
            addToHead(newnode);
            size++;
        } else {
            DLinkNode node = cache.get(key);
            node.val = value;
            moveToHead(node);
        }
    }

    private class DLinkNode {
        int key;
        int val;
        DLinkNode pre;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void addToHead(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail() {
        DLinkNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }
}
