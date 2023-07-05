// 챕터 3 - 5
package com.example.basic;
import java.util.ArrayList;
import java.util.List;

// 사람을 만든다고
public class BasicMain {
    public static void main(String[] args) {
        Person studentKim = new Student("kim", 22);
        Student studentLee = new Student("Lee", 26);
        Person studentPark = new Student("Park", 24);

        Person lecturer = new Lecturer("Kim Kb", 22);

        List<Person> everyone = new ArrayList<>();
        everyone.add(studentKim);
        everyone.add(studentLee);
        everyone.add(studentPark);
        everyone.add(lecturer);

        for (Person person: everyone) {
            person.speak();
        }


    }
}
