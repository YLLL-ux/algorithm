package com.ylllux.study;

import com.ylllux.study.demo_01_linkedList.LinkedList;
import com.ylllux.study.demo_01_linkedList.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 算法测试
 * @Author Phil
 * @CreateTime 2022/8/23
 **/

public class AlgorithmsTest {

    private Logger logger = LoggerFactory.getLogger(AlgorithmsTest.class);

    @Test
    public void test_linked_list() {
        List<String> list = new LinkedList<>();
        // 添加元素
        list.add("a");
        list.addFirst("b");
        list.addLast("c");
        // 打印列表
        list.printLinkedList();
        // 头插元素
        list.addFirst("d");
        // 删除元素
        list.remove("b");
        // 打印列表
        list.printLinkedList();
    }
}
