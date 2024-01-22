package com.webatrio.test.webatrio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.webatrio.test.webatrio.model")
public class WebatrioApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebatrioApplication.class, args);
	}

}
