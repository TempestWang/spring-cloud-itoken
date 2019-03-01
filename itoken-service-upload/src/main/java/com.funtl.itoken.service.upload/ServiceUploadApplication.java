package com.funtl.itoken.service.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * User: Swang
 * Date: 2019-02-10
 * Time: 17:57
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUploadApplication.class, args);
    }
}
