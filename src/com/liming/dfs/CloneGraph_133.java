package com.liming.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ltf
 * @date 2021-07-17 10:15
 * 133. 克隆图
 */
public class CloneGraph_133 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> cloned = new HashMap<>();
        return dfs(node, cloned);
    }

    private Node dfs(Node node, Map<Node, Node> cloned) {
        if (node == null) return null;
        if (cloned.containsKey(node)) return cloned.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        cloned.put(node,clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, cloned));
        }
        return clone;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
