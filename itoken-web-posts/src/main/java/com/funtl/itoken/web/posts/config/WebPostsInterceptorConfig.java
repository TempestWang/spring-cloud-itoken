package com.funtl.itoken.web.posts.config;

import com.funtl.itoken.web.posts.interceptor.WebPostsInterceptor;
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
public class WebPostsInterceptorConfig implements WebMvcConfigurer {

    @Bean
    WebPostsInterceptor webPostsInterceptor() {
        return new WebPostsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webPostsInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/static");
    }
}
