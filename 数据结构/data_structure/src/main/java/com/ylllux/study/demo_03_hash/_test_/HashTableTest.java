package com.ylllux.study.demo_03_hash._test_;

import com.ylllux.study.demo_03_hash.HashMap01;
import com.ylllux.study.demo_03_hash.HashMap02BySeparateChaining;
import com.ylllux.study.demo_03_hash.HashMap03ByOpenAddressing;
import com.ylllux.study.demo_03_hash.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;

/**
 * @Description TODO
 * @Author Phil
 * @CreateTime 2022/9/2
 **/

public class HashTableTest {

    private Logger logger = LoggerFactory.getLogger(HashTableTest.class);

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

    @Test
    public void test_hashMap02() {
        Map<String, String> map = new HashMap02BySeparateChaining<>();
        map.put("01", "花花");
        map.put("05", "豆豆");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));

        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));
    }

    @Test
    public void test_hashMap03() {
        Map<String, String> map = new HashMap03ByOpenAddressing<>();
        map.put("01", "花花");
        map.put("05", "豆豆");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));
        // 下标碰撞
        map.put("09", "蛋蛋");
        map.put("12", "苗苗");
        logger.info("碰撞前 key：{} value：{}", "01", map.get("01"));
    }

}
