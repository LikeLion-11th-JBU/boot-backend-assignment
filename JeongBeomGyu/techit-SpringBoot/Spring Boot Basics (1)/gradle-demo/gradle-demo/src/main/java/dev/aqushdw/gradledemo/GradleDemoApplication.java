package dev.aqushdw.gradledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradleDemoApplication {
//	TestComponent testComponent = new TestComponent(
//			// TestComponent는 TestInterface가 필요하다.
//			new TestInterface(){
//				@Override
//				public void sayHello(){
//					System.out.println("hello world! this is temp interface");
//				}
//			}
//	);	// new 키워드를 통해서 TestComponent라는 객체에 객체를 하나 생성해서 넣어주게된다.

	public static void main(String[] args) {
		SpringApplication.run(GradleDemoApplication.class, args);
	}


}
