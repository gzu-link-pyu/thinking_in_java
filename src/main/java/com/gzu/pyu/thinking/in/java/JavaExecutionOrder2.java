package com.gzu.pyu.thinking.in.java;

public class JavaExecutionOrder2 {
    
    public static void main(String args[]){
        System.out.println("Start Java Execution Order：");
        TestB b = new TestB();
    }
}

class TestA{
    TestC c =new TestC();
    
    static {
        System.out.println("TestA's Static code block");
    }
    
    public TestA(){
        System.out.println("TestA's Constructor");
    }
}

class TestB extends TestA{
	TestC c =new TestC();
	TestD d = new TestD();
	
	static {
		System.out.println("TestB's Static code block");
	}
	
    public TestB(){
        System.out.println("TestB's Constructor");
    }
}

class TestC {
	static {
        System.out.println("TestC's Static code block");
    }
	
    public TestC(){
        System.out.println("TestC's Constructor");
    }
}

class TestD{
	static {
        System.out.println("TestD's Static code block");
    }
	
    public TestD(){
        System.out.println("TestD's Constructor");
    }
}