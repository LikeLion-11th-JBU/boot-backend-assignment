// 챕터3 - 5
package com.example.basic.challenge;
import com.example.basic.Lecturer;
import com.example.basic.Person;
import com.example.basic.Student;

import java.util.*;

public class ChallengeMain {
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

        printItems(everyone);

    }

    public static <T> void printItems(Iterable<T> iterable){
        Iterator<T> iterator = iterable.iterator();
        if(!iterator.hasNext()){
            System.out.println("No Elements");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idx\t\titem\n");
        for (int i = 0; iterator.hasNext(); i++){
           T item = iterator.next();
           stringBuilder.append(
                   String.format("%d\t\t%s\n", i, item));
        }

        System.out.println(stringBuilder);

    }



}
