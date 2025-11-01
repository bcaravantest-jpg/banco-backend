package com.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancoBackendApplication {

	 public static void main(String[] args) {
	        SpringApplication.run(BancoBackendApplication.class, args);
	        System.out.println("🚀 Servidor Banco Backend iniciado correctamente...");
	    }
}
