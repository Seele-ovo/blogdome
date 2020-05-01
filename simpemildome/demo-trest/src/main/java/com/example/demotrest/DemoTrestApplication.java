package com.example.demotrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulProxy
public class DemoTrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTrestApplication.class, args);
    }

}
