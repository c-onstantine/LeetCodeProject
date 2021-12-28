package com.liming.offerspecial;

/**
 * @author ltf
 * @date 2021-12-28 20:23
 */
public class Offer_II_067 {
    Trie root = new Trie();

    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            res = Math.max(res, search(num));
        }
        return res;
    }

    private void insert(int num) {
        Trie cur = root;
        int d = 0;
        for (int i = 30; i >= 0; i--) {
            d = num >> i & 1;
            if (cur.next[d] == null) {
                cur.next[d] = new Trie();
            }
            cur = cur.next[d];
        }
    }

    private int search(int num) {
        Trie cur = root;
        int xorNum = 0; // 要与num异或得到最大值的数
        int d = 0, otherd = 0;
        for (int i = 30; i >= 0; i--) {
            d = num >> i & 1;
            otherd = d == 0 ? 1 : 0;
            if (cur.next[otherd] == null) {
                cur = cur.next[d];
                xorNum = xorNum * 2 + d;
            } else {
                cur = cur.next[otherd];
                xorNum = xorNum * 2 + otherd;
            }
        }
        return num ^ xorNum;
    }

    private class Trie {
        Trie[] next = new Trie[2];
    }
}
