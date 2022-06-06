package org.cory.rice.bingetv;

import org.cory.rice.bingetv.services.ApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(BingeTvConfigProperties.class)
@SpringBootApplication
public class BingeTvBackendApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BingeTvBackendApplication.class, args);
	}
	
}
