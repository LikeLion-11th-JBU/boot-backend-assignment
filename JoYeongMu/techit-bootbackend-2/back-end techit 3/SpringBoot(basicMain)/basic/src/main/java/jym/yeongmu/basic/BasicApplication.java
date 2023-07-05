package jym.yeongmu.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BasicApplication {
	public static void main(String[] args) {
		Person studentLee = new Student("Lee", 24 );
		Person studentKim = new Student("Kim", 91 );
		Person studentJo = new Student("Jo", 24 );
		Lecturer lecturer = new Lecturer("Jo Yeongmu" , 24);

		List<Person> everyone = new ArrayList<>();
		everyone.add(studentLee);
		everyone.add(studentKim);
		everyone.add(studentJo);
		everyone.add(lecturer);

		for (Person person: everyone) {

		}

	}

}
