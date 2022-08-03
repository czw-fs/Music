package com.example.onlinemusic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 12629
 * @Date 2022/4/11 17:22
 * @Description：
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 添加拦截器：
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //登录之后才能访问其他的页面.....
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        registry.addInterceptor(loginInterceptor).
                addPathPatterns("/**")
                .excludePathPatterns("/js/**.js")
                //排除images下所有的元素
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/css/**.css")
                .excludePathPatterns("/fronts/**")
                .excludePathPatterns("/player/**")
                .excludePathPatterns("/login.html")
                //排除登录接口
                .excludePathPatterns("/user/login");
    }
}
