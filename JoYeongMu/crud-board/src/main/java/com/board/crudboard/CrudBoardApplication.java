package com.board.crudboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class CrudBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudBoardApplication.class, args);
	}

}
