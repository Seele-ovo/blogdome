package cn.exampl.useradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServerUser {
    public static void main(String[] args) {
        SpringApplication.run(ServerUser.class,args);
    }
}
