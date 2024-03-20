package juc.study;

import java.util.concurrent.ConcurrentHashMap;

public class TestDemo {
    public static void main(String[] args) {
        String str1 = new StringBuffer("ja").append("va").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());
        System.out.println(str1.equals(str1.intern()));

        String str2 = new StringBuffer("58").append("city").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());


        ConcurrentHashMap<Object, Object> s = new ConcurrentHashMap<>();

    }
}
