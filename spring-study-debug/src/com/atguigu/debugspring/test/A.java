package com.atguigu.debugspring.test;

public class A {

    private B b;
    public B getB()
    {
        return b;
    }

    public void setB(B b)
    {
        this.b = b;
    }

    public A()
    {
        System.out.println("---A created success");
    }
}
