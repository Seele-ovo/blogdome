package com.example.clondgw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClondGwApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClondGwApplication.class, args);
    }

}
