package com.selamino.tvseries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
//@EnableFeignClients("com.selamino.tvseries")
@SpringBootApplication
public class SelaminoTvSeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelaminoTvSeriesApplication.class, args);
	}

}

