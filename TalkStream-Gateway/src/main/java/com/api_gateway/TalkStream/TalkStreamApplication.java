package com.api_gateway.TalkStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TalkStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalkStreamApplication.class, args);
	}

}
