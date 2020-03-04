package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaConfigHighApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigHighApp.class,args);
    }
}