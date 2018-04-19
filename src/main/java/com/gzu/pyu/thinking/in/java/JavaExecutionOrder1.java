package com.gzu.pyu.thinking.in.java;

public class JavaExecutionOrder1 {
	
	public static void main(String[] args) {
		new HelloA();
		System.out.println("-----------------");
		new HelloB();	
	}

}

class HelloC{
	
	HelloC(){
	   System.out.println("HelloC constructor");
	}
	
	static{
		System.out.println("HelloC static code block");
	}
	
	{
		System.out.println("HelloC code block");
	}
}

class HelloA{
	
	HelloA(){
	   System.out.println("HelloA constructor");
	}
	
	static{
		System.out.println("HelloA static code block");
	}
	
	{
		System.out.println("HelloA code block");
	}
}

class HelloB extends HelloA{
	
	public static String name="";
	
	HelloB(){
	   System.out.println("HelloB constructor");
	}
	
	static{
		System.out.println("HelloB static code block");
	}
	
	{
		System.out.println("HelloB code block");
	}
}

