package com.example.basic;

public class Student extends Abstractperson{
    public Student(String name, int age){
        super(name, age);
        // super -> 자신이 상속받은 부모 객체의 함수들을 호출할 수 있는 키워드.
    }

    @Override
    public void speak() {
        System.out.println(String.format("My name is %s. and I am a student", getName()));

    }




}
