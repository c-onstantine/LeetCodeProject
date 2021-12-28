package com.liming.offerspecial;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ltf
 * @date 2021-12-28 19:48
 */
public class Offer_II_066 {
    private Trie root = new Trie();

    /**
     * Initialize your data structure here.
     */
    public Offer_II_066() {

    }

    public void insert(String key, int val) {
        Trie cur = root;
        for (char c : key.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new Trie();
            }
            cur = cur.child[c - 'a'];
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Trie cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                return 0;
            }
            cur = cur.child[c - 'a'];
        }
        int res = 0;
        //bfs
        Deque<Trie> queue = new ArrayDeque<>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            Trie poll = queue.poll();
            res += poll.val;
            for (int i = 0; i < poll.child.length; i++) {
                if (poll.child[i] != null) {
                    queue.offer(poll.child[i]);
                }
            }
        }
        return res;
    }

    private class Trie {
        Trie[] child = new Trie[26];
        int val;
    }
}
