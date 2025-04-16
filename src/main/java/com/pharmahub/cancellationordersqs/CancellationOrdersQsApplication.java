package com.pharmahub.cancellationordersqs;

import com.pharmahub.cancellationordersqs.configurations.ExternalApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class CancellationOrdersQsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CancellationOrdersQsApplication.class, args);
	}

}
