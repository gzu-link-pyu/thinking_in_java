package com.gzu.pyu.test.controller;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Pattern;

public class TestContronller {
    /**
     * 初始化一个有值的List
     * 使用LinkedList维护一个插入顺序，方便观察遍历时的顺序
     */
    private static List<String> traverseList=new ArrayList<String>(){{
        add("gzu ");
        add("pyu ");
        add("thinking ");
        add("in ");
        add("java ");
    }};

    /**
     * 初始化一个有值的map
     */
    private static Map<String, String> traverseMap = new LinkedHashMap<String, String>() {{
        put("school", "gzu ");
        put("name", "pyu ");
        put("book", "thinking_in_java");
    }};

    @Test
    public void test(){

        List<String> targetList = new ArrayList<String>(){{
            add("operation.xml");
            add("adfaoperation.xml");
            add("operation_sdfsf.xml");
            add("operation.xml.sdfsf");
            add("sdfsoperationsdfs.sdfxmlsdf");
        }};

        String match="[a-z]operation[a-z._].[a-z._]xml[a-z._]";

        ListIterator<String> iterator = targetList.listIterator();
        while (iterator.hasNext()){

            boolean b = Pattern.compile(match).matcher(iterator.next()).find();
            System.out.println(b);
        }


    }

}
