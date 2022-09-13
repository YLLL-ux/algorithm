package com.ylllux.study.demo_03_hash;

/**
 * @Description 不完美哈希（会发生哈希碰撞）
 * <p>
 * 通过对一个 Key 值计算它的哈希并与长度为2的n次幂的数组减一做与运算，计算出槽位对应的索引，将数据存放到索引下。
 * 那么当获取指定数据时，只需要根据存放时计算索引ID的方式再计算一次，就可以把槽位上对应的数据获取处理，以此达到时间复杂度为O(1)的目的。
 * @Author Phil
 * @CreateTime 2022/8/31
 **/

public class HashMap01<K, V> implements Map<K, V> {

    private final Object[] tab = new Object[8]; //长度为2的n次幂

    @Override
    public void put(K key, V value) {
        int idx = key.hashCode() & (tab.length - 1);
        tab[idx] = value;
    }

    @Override
    public V get(K key) {
        int idx = key.hashCode() & (tab.length - 1);
        return (V) tab[idx];
    }
}
