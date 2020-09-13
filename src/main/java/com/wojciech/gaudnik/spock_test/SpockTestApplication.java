package com.wojciech.gaudnik.spock_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class SpockTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpockTestApplication.class, args);
	}

}
