package challenge;

import basic.Lecturer;
import basic.Person;
import basic.Student;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ChallengeMain {
    public static void main(String[] args) {
        Person studentKim = new Student("kim",20);
        Person studentLee = new Student("Lee",21);
        Person studentPark = new Student("Park",22);

        Person lecturer = new Lecturer("SeungIL", 24);

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
            System.out.println("NO ELEMENTS");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idx\t\titem\n");
        for(int i = 0; iterator.hasNext(); i++){
            T item = iterator.next();
            stringBuilder.append(
                    String.format("%d\t\t%s\n",i,item));
        }
        System.out.println(stringBuilder);
    }
}
