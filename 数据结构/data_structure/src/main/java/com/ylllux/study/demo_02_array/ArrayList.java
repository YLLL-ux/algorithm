package com.ylllux.study.demo_02_array;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Phil
 * @CreateTime 2022/8/29
 **/

public class ArrayList<E> implements List<E> {

    // 默认初始空间
    private static final int DEFAULT_CAPACITY = 10;
    // 空元素
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    // arrayList元素数组缓存区
    transient Object[] elementData;
    // List集合元素数量
    private int size;

    public ArrayList() {
        // 默认给个空元素，当开始添加元素的时候在初始化长度
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public boolean add(E e) {
        // 确保内部容量
        int minCapacity = size + 1;
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        // 判断扩容操作
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
        }

        // 添加元素
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // 从原始数组的某个位置，拷贝到目标对象的某个位置开始后n个元素
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        // 将已经删除的元素设置为null
        elementData[--size] = null;
        return oldValue;
    }

    @Override
    public E getIndex(int index) {
        return (E) elementData[index];
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }
}
