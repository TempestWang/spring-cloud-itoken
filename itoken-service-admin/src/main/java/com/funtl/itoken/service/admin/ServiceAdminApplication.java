package com.funtl.itoken.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * User: Swang
 * Date: 2019-01-30
 * Time: 15:42
 */
@SpringBootApplication(scanBasePackages = "com.funtl.itoken")
@EnableEurekaClient
@MapperScan(basePackages = {"com.funtl.itoken.common.mapper", "com.funtl.itoken.service.admin.mapper"})
public class ServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
    }
}