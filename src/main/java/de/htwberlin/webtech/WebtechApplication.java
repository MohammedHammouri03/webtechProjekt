package de.htwberlin.webtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class WebtechApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtechApplication.class, args);
	}
}
