package com.hithaui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.hithaui")
@SpringBootApplication
public class DemoB2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoB2Application.class, args);
	}

}
