package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author mla
 * @description
 * @prjectName microcloud
 * @className ConfigApp
 * @date 2020/3/4  21:26
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApp2 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp2.class,args);
    }
}
