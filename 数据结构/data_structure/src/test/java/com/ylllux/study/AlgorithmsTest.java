package com.ylllux.study;

import com.ylllux.study.demo_01_linkedList.LinkedList;
import com.ylllux.study.demo_01_linkedList.List;
import com.ylllux.study.demo_03_hash.HashMap01;
import com.ylllux.study.demo_03_hash.Map;
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

    @Test
    public void test_hashMap01() {
        Map<String, String> map = new HashMap01<>();
        map.put("01", "花花");
        map.put("02", "豆豆");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));
    }

}
