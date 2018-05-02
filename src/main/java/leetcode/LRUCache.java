package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

        Follow up:
        Could you do both operations in O(1) time complexity?
*/

class LRUCache {
    private final FixedSizeLinkedHashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new FixedSizeLinkedHashMap<>(capacity);
    }

    //TODO Not accepted because Java LinkedListHashMap will evict even for get where it's not case in problem requirement

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        private final int max;

        public FixedSizeLinkedHashMap(int capacity) {
            super(capacity, 0.75f, false);
            max = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > max;
        }

    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new FixedSizeLinkedHashMap<>(3);
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        System.out.println(map.keySet());
        map.get(2);
        System.out.println(map.keySet());
        map.put(4, 40);
        System.out.println(map.keySet());

    }

}
