package de.htwberlin.webtech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebtechApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("check if the main method is working")
	void testMain() {
		String[] args = new String[]{"--spring.config.name=test"};
		SpringApplication.run(WebtechApplication.class, args);
	}
}
