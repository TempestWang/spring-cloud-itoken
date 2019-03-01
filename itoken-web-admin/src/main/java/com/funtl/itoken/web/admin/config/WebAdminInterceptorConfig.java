package com.funtl.itoken.web.admin.config;

import com.funtl.itoken.web.admin.interceptor.WebAdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * User: Swang
 * Date: 2019-01-29
 * Time: 11:05
 */
@Configuration
public class WebAdminInterceptorConfig implements WebMvcConfigurer {

    @Bean
    WebAdminInterceptor webAdminInterceptor() {
        return new WebAdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webAdminInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/static");
    }
}