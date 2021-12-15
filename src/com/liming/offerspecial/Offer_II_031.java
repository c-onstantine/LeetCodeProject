package com.liming.offerspecial;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-12-15 21:34
 */
public class Offer_II_031 {
    private class Node {
        private Node next;
        private Node pre;
        private int val;
        private int key;

        public Node() {
        }

        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    private Node head = new Node();
    private Node tail = new Node();
    private int cap = 0;
    private Map<Integer, Node> map;

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        deleteNode(node);
        addToHead(node);
    }

    public Offer_II_031(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == cap) {
                Node node = tail.pre;
                deleteNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
        } else {
            Node node = map.get(key);
            node.val = value;
            map.put(key, node);
            moveToHead(node);
        }
    }
}
