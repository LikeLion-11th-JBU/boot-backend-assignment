package basic;

import java.util.ArrayList;
import java.util.List;

public class BasicMain {
    public static void main(String[] args){
        Person studentKim = new Student("kim",20);
        Person studentLee = new Student("Lee",21);
        Person studentPark = new Student("Park",22);

        Person lecturer = new Lecturer("SeungIL", 24);

        List<Person> everyone = new ArrayList<>();
        everyone.add(studentKim);
        everyone.add(studentLee);
        everyone.add(studentPark);
        everyone.add(lecturer);

        for(Person person : everyone){
            person.speak();
        }
    }
}
