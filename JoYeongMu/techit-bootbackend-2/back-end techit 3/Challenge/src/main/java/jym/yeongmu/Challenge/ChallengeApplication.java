package jym.yeongmu.Challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ChallengeApplication {
	public static void main(String[] args) {
		ArrayList a;
		LinkedList b;
		Vector c;
		HashSet d;

	}

	public static <T>void printItems(Iterable<T> iterable) {
		Iterator<T> iterator = iterable.iterator();
		if (!iterator.hasNext()) {
			System.out.println("No Elements");
			return;

		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("idx\t\titem\n");
		for (int i = 0; iterator.hasNext(); i++) {
			T item = iterator.next();
			stringBuilder.append(
					String.format("%d\t\t%s\n", i,item.toString()));
		}
		System.out.println(stringBuilder);
	}
}
