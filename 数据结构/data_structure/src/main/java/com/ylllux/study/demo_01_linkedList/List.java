package com.ylllux.study.demo_01_linkedList;

/**
 * @Description List接口
 * @Author Phil
 * @CreateTime 2022/8/23
 **/

public interface List<E> {

    boolean add (E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkedList();
}
