package com.ylllux.study.demo_02_array;

/**
 * @Description TODO
 * @Author Phil
 * @CreateTime 2022/8/29
 **/

public interface List<E> {

    boolean add(E e);

    E remove(int index);

    E getIndex(int index);
}
