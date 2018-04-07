package com.gzu.pyu.thinking.in.java.practice0211;

public class JavaExtends {

    public static void main(String[] args){
        new C("");
    }
}

class A{
    private String s;
    public A(String s) {
        this.s=s;
        System.out.println("A Construtor");
    }
}

class B{
    private String s;
    public B(String s) {
        this.s=s;
        System.out.println("B Construtor");
    }

    public void a(){}
    public void b(){}
    public void c(){}
}
class C extends A{

    private String s;
    private B b=new B("234234");

    public void a() {
        b.a();
    }

    public void b() {
        b.b();
    }

    public void c() {
        b.c();
    }

    public C(String s) {
        super(s);
        this.s=s;
        System.out.println("C Construtor");
    }
    public C() {
        super("");
        this.s=s;
        System.out.println("C Construtor");
    }
}

