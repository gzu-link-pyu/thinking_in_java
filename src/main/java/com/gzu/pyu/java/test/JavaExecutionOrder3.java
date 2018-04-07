package com.gzu.pyu.java.test;

public class JavaExecutionOrder3 {
    
    public static void main(String args[]){
        System.out.println("Start Java Execution Order：");
        B b = new B();
    }
}

class A{
    C c =new C();
    {
    	System.out.println("TestA's Code block");
    }
    
    static {
        System.out.println("TestA's Static code block");
    }
    
    public A(){
        System.out.println("TestA's Constructor");
    }
}

class B extends A {
	//注意：静态成员对象，和非静态成员对象的初始化顺序和实际
	static C c =new C();
	D d = new D();
	
	static {
		System.out.println("TestB's Static code block");
	}
	
	{
    	System.out.println("TestB's Code block");
    }
	
    public B(){
        System.out.println("TestB's Constructor");
    }
}

class C {
	static {
        System.out.println("TestC's Static code block");
    }
	
	{
    	System.out.println("TestC's Code block");
    }
	
    public C(){
        System.out.println("TestC's Constructor");
    }
}

class D{
	static {
        System.out.println("TestD's Static code block");
    }
	
	{
    	System.out.println("TestD's Code block");
    }
	
    public D(){
        System.out.println("TestD's Constructor");
    }
}