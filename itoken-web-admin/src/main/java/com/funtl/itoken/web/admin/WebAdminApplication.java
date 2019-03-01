package com.funtl.itoken.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * User: Swang
 * Date: 2019-01-26
 * Time: 11:57
 */
@SpringBootApplication(scanBasePackages = "com.funtl.itoken")
@EnableDiscoveryClient
@EnableFeignClients
public class WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }
}
