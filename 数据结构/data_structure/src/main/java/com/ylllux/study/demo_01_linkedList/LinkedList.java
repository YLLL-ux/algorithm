package com.ylllux.study.demo_01_linkedList;

/**
 * @Description 实现链表
 * @Author Phil
 * @CreateTime 2022/8/23
 **/

public class LinkedList<E> implements List<E> {

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public LinkedList() {
    }

    /**
     * 头插节点
     *
     * @param e
     */
    void linkFirst(E e) {
        /*
            1、记录第一个节点
            2、创建新节点
            3、新节点放到第一个节点位置处，记录的第一个节点的上一个节点为新节点
            4、若原来就没有头节点，直接设置新节点
         */
        Node<E> f = first;
        Node<E> newNode = new Node<E>(null, e, f);
        first = newNode;
        if (f == null) // 没有节点
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    /**
     * 尾插节点
     *
     * @param e
     */
    void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * 拆链操作
     *
     * @param x
     * @return
     */
    E unlink(Node<E> x) {
        // 获取当前节点属性
        E element = x.item;
        Node<E> prev = x.prev;
        Node<E> next = x.next;

        // 拆除节点为头节点
        if (prev == null) {
            first = next; // 头节点变为拆除节点的下一节点
        } else {
            // 拆除节点的上一节点指向拆除节点的下一节点
            prev.next = next;
            // 拆除节点的上一节点为null
            x.prev = null;
        }

        // 拆除节点为尾节点
        if (next == null) {
            // 尾节点为拆除节点的上一节点
            last = prev;
        } else {
            // 拆除节点的下一节点指向拆除节点的上一节点
            next.prev = prev;
            // 拆除节点下一节点为null
            x.next = null;
        }

        // 拆除节点元素值为null
        x.item = null;
        size--;
        return element;
    }

    @Override
    public boolean add(E e) {
        linkLast(e); // 单链表添加
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        // 从链表中找到o，并将其剔除
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) { // 剔除元素值为null的节点
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    /**
     * 使用二分查找获取index处节点的元素
     *
     * @param index
     * @return
     */
    Node<E> node(int index) {
        Node<E> x;
        if (index < (size >> 1)) { // size >> 1 == size/2取整; size << 1 == size*2
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    @Override
    public void printLinkedList() {
        if (this.size == 0) {
            System.out.println("linkedList is null.");
        } else {
            Node<E> temp = first;
            System.out.println("当前链表，头节点：" + first.item + " 尾节点：" + last.item + " 整体：");
            while (temp != null) {
                System.out.println(temp.item);
                temp = temp.next;
            }
            System.out.println();
        }
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
