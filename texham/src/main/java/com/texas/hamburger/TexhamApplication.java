package com.texas.hamburger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import lombok.extern.java.Log;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class TexhamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TexhamApplication.class, args);
	
	}

}
