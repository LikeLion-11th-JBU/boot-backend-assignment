package jym.yoengmu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		TestComponent testComponent = new TestComponent(
//				new TestIntetface() {
//					@Override
//					public void sayHello() {
//						System.out.println("hello world");
//					}
//				}
//		);
//		TestComponent.sayHello();
		SpringApplication.run(DemoApplication.class, args);
	}

}
