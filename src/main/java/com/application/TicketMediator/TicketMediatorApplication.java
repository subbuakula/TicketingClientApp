package com.application.TicketMediator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.application.TouristFeignClient")
public class TicketMediatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketMediatorApplication.class, args);
	}

}
