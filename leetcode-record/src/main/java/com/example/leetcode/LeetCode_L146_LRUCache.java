package com.example.leetcode;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LeetCode_L146_LRUCache {
    public static void main(String[] args) {

    }
}


class LRUCache {
    Map<Integer, LRUNode> map;
    int capacity;
    LRUNode head = new LRUNode(-1, -1), tail = new LRUNode(-1, -1);

    public LRUCache(int capacity) {
        map = new ConcurrentHashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LRUNode lruNode = map.get(key);
            int value = lruNode.value;
            map.remove(key);
            removeNode(lruNode);

            map.put(key, lruNode);
            addNodeFirst(lruNode);

            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            map.remove(key);
            removeNode(node);

        }
        LRUNode lruNode = new LRUNode(key, value);
        map.put(key, lruNode);
        addNodeFirst(lruNode);


        if (map.size() > capacity) {
            LRUNode prev = tail.prev;
            map.remove(prev.key);
            removeNode(prev);
        }

    }

    public void addNodeFirst(LRUNode node) {

        LRUNode nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public void removeNode(LRUNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

}

class LRUNode {
    int key;
    int value;
    LRUNode next;
    LRUNode prev;


    LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

}
