package com.funtl.itoken.web.backend.config;

import com.funtl.itoken.web.backend.interceptor.WebBackendInterceptor;
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
public class WebBackendInterceptorConfig implements WebMvcConfigurer {

    @Bean
    WebBackendInterceptor webPostsInterceptor() {
        return new WebBackendInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webPostsInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/static");
    }
}
