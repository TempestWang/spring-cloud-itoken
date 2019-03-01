package com.funtl.itoken.common.web.config;

import com.funtl.itoken.common.web.interceptor.ConstantsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * User: Swang
 * Date: 2019-01-29
 * Time: 10:18
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ConstantsInterceptor()).addPathPatterns("/**");
    }
}
