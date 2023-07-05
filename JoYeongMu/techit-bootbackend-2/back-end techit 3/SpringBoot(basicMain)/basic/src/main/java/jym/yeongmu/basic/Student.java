package jym.yeongmu.basic;

public class Student extends  AbstractPerson {
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println(String.format("name is % s", getName()));
    }
}
