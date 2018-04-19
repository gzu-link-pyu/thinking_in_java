package com.gzu.pyu.thinking.in.java;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * java遍历map的多种方法
 * 分为类
 * 1、普通的循环遍历
 * 2、jdk8以上的新特性
 *
 * @author pyu
 */
public class TraverseMap {
    /**
     * 初始化一个有值的map
     */
    private static Map<String, String> traverseMap = new LinkedHashMap<String, String>() {{
        put("school", "gzu ");
        put("name", "pyu ");
        put("book", "thinking_in_java");
    }};

    /**
     * *********************************************
     * 以下为jdk8及以上的遍历方式
     */
    @Test
    public void test7() {
        System.out.println("TraverseMap method7:");
        traverseMap.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });
        System.out.println();
    }

    @Test
    public void test6() {
        System.out.print("TraverseMap method6:");
        traverseMap.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + "=" + value);
            }
        });
        System.out.println();
    }

    /**
     * 多线程并行执行
     */
    @Test
    public void test5() {
        System.out.print("TraverseMap method5:");
        traverseMap.keySet().parallelStream().forEach(key -> {
            System.out.println(key + "=" + traverseMap.get(key));
        });
        System.out.println();
    }

    /**
     * 串行执行
     */
    @Test
    public void test4() {
        System.out.print("TraverseMap method4:");
        traverseMap.keySet().stream().forEach(key -> {
            System.out.println(key + "=" + traverseMap.get(key));
        });
        System.out.println();
    }


    /**
     * *********************************************
     * 以下为java常规遍历map的方式
     * 1.优先选择foreach
     * 2.遍历List的同时要移除元素推荐使用iterator
     */
    @Test
    public void test3() {
        System.out.println("TraverseMap method3:");
        Iterator<String> iterator = traverseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next + "=" + traverseMap.get(next));
        }
        System.out.println();
    }

    /**
     * //java8之前的强烈推荐推荐，尤其是容量大时
     */
    @Test
    public void test2() {
        System.out.println("TraverseMap method2:");
        for (Map.Entry<String, String> entry : traverseMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println();
    }

    @Test
    public void test1() {
        System.out.println("TraverseMap method2:");
        for (String key : traverseMap.keySet()) {
            System.out.println("map.get(" + key + ") = " + traverseMap.get(key));
        }
        System.out.println();
    }

    //只能遍历value的值
    @Test
    public void test() {
        System.out.println("TraverseMap method0:");
        for (String value : traverseMap.values()) {
            System.out.println("map.value:" +value);
        }
        System.out.println();
    }
}