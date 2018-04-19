package com.gzu.pyu.learn.arithmetic;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * Stack算法学习
 * 1.使用LinkedList实现站
 */
public class StackLearn {

    @Test
    public void test2(){


    }

    @Test
    public void test1(){
        StackLinkedList<String> stack = new StackLinkedList<>();
        System.out.println(stack.empty());
        System.out.println(stack);

        stack.push("! ");
        stack.push("world ");
        stack.push("hello ");
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.empty());
    }

}

/**
 * 使用LinkedList，包装一下，实现一个Stack
 * @param <T>
 */
class StackLinkedList<T>{
    private LinkedList<T> storage=new LinkedList<>();

    /**
     * 接受T类型的参数，将其加入栈顶
     * @param e
     */
    public void push(T e){
        storage.addFirst(e);
    }

    /**
     * 出栈：删除栈顶元素，并返回
     * @return
     */
    public T pop(){
        return storage.removeFirst();
    }

    /**
     * 返回栈顶元素，不删除
     * @return
     */
    public T peek(){
        return storage.getFirst();
    }

    /**
     * 判断这个栈是否是空的
     * @return
     */
    public Boolean empty(){
        return storage.isEmpty();
    }

    public String toString(){
        return storage.toString();
    }

}