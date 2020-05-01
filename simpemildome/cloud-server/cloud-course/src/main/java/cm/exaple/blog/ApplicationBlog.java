package cm.exaple.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationBlog {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationBlog.class, args);
    }
}
