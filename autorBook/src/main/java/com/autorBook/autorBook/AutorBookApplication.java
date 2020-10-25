package com.autorBook.autorBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutorBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutorBookApplication.class, args);
		System.out.println("IoC container was loaded");
	}

}
