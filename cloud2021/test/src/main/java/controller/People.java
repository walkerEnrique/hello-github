package controller;

import java.io.Serializable;

public class People implements Serializable {

    private String name;
    private Integer age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return name + ":" +age;
    }
}
