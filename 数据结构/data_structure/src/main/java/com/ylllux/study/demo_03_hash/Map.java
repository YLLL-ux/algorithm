package com.ylllux.study.demo_03_hash;

/**
 * @Description TODO
 * @Author Phil
 * @CreateTime 2022/8/31
 **/

public interface Map<K, V> {

    void put(K key, V value);

    V get(K key);
}
