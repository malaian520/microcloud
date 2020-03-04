package cn.enjoy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mla
 * @description
 * @prjectName microcloud
 * @className ConfigController
 * @date 2020/3/4  21:47
 */
@RestController
public class ConfigController {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String eurekaServices;

    @RequestMapping("/config")
    public String getConfig() {
        return "applicationName:" + applicationName + "\n\reurekaServices:" + eurekaServices;
    }
}
