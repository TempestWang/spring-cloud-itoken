package com.funtl.itoken.service.digiccy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * User: Swang
 * Date: 2019-02-12
 * Time: 14:15
 */
@SpringBootApplication(scanBasePackages = "com.funtl.itoken")
@EnableEurekaClient
public class ServiceDigiccyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDigiccyApplication.class, args);
    }
}
