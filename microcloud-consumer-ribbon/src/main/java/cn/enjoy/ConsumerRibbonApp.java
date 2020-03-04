package cn.enjoy;
import cn.xiangxue.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(value = "MICROCLOUD-PROVIDER-PRODUCT",configuration = RibbonConfig.class)
public class ConsumerRibbonApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApp.class,args);
    }
}