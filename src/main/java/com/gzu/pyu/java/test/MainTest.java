package com.gzu.pyu.java.test;

public class MainTest {
	public static void main(String[] args) {
		int i = 10;
		System.out.println("i="+i);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toHexString(i));
		System.out.println(Integer.toOctalString(i));

		long L = 12L;
		System.out.println("L="+L);
		System.out.println(Long.toBinaryString(L));
		System.out.println(Long.toHexString(L));
		System.out.println(Long.toOctalString(L));
		
	}
}
