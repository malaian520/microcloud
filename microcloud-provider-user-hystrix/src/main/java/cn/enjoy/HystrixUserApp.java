package cn.enjoy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@EnableCircuitBreaker
public class HystrixUserApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixUserApp.class,args);
    }
}