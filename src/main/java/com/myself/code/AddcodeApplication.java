package com.myself.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.myself.winter"})
public class AddcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddcodeApplication.class, args);
	}
}
