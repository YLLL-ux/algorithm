package com.ylllux.study.demo_03_hash;

/**
 * @Description 开放寻址，每个条目记录都存储在数组本身中，并通过探测执行哈希解决
 * @Author Phil
 * @CreateTime 2022/9/2
 **/

public class HashMap03ByOpenAddressing<K, V> implements Map<K, V> {

    private final Node<K, V>[] tab = new Node[8]; //槽位索引

    @Override
    public void put(K key, V value) {
        int idx = key.hashCode() & (tab.length - 1);
        if (tab[idx] == null) {
            tab[idx] = new Node<>(key, value);
        } else {
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] == null) {
                    tab[i] = new Node<>(key, value);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int idx = key.hashCode() & (tab.length - 1);
        for (int i = 0; i < tab.length; i++) {
            if (tab[idx] != null && tab[idx].key == key) return tab[idx].value;
        }
        return null;
    }

    static class Node<K, V> {
        final K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
