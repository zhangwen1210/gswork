package com.servyou.gswork.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: gswork->WebConfigurer
 * @description:
 * @author: zhangwen
 * @create: 2020-05-29 11:12
 **/
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/houtai/loginpage", "/", "/css/*", "/email_templates", "/font-awesome/*", "/fonts/*", "/img/*", "/js/*", "/LESS/*");*/

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/gswork/**");
    }
}
