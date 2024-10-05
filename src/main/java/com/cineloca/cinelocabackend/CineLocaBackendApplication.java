package com.cineloca.cinelocabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CineLocaBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(CineLocaBackendApplication.class, args);
	}

}
