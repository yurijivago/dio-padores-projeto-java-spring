package com.yurijivago.diopadoresprojetojavaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioPadoresProjetoJavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioPadoresProjetoJavaSpringApplication.class, args);
	}

}
