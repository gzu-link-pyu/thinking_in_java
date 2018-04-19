package com.gzu.pyu.thinking.in.java;

public class JavaExecutionOrder3 {
    
    public static void main(String args[]){
        System.out.println("Start Java Execution Order：");
        OrderB b = new OrderB();
    }
}

class OrderA{
    OrderC c =new OrderC();
    {
    	System.out.println("TestA's Code block");
    }
    
    static {
        System.out.println("TestA's Static code block");
    }
    
    public OrderA(){
        System.out.println("TestA's Constructor");
    }
}

class OrderB extends OrderA {
	//注意：静态成员对象，和非静态成员对象的初始化顺序和实际
	static OrderA c =new OrderA();
    OrderD d = new OrderD();
	
	static {
		System.out.println("TestB's Static code block");
	}
	
	{
    	System.out.println("TestB's Code block");
    }
	
    public OrderB(){
        System.out.println("TestB's Constructor");
    }
}

class OrderC {
	static {
        System.out.println("TestC's Static code block");
    }
	
	{
    	System.out.println("TestC's Code block");
    }
	
    public OrderC(){
        System.out.println("TestC's Constructor");
    }
}

class OrderD{
	static {
        System.out.println("TestD's Static code block");
    }
	
	{
    	System.out.println("TestD's Code block");
    }
	
    public OrderD(){
        System.out.println("TestD's Constructor");
    }
}