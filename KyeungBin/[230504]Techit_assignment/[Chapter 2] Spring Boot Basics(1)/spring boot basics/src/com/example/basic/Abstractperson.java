package com.example.basic;

public abstract class Abstractperson implements Person {
    protected String name;
    private int age;



    public Abstractperson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void speak() {
        System.out.println(String.format("Hi, my name is %s.", this.name));
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Abstractperson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
