package com.umg.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Ejercicio2CacheLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2CacheLibrosApplication.class, args);
	}

}
