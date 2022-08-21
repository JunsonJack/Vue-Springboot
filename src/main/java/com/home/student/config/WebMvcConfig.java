package com.home.student.config;

import com.home.student.interceptor.AuthrizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 自定义的webmvc配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private AuthrizationProperties authrizationProperties;

    @Bean
    public AuthrizationInterceptor authrizationInterceptor(){
        return new AuthrizationInterceptor();

   }

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authrizationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(authrizationProperties.getIgnoreUrls());
    }

    /**
     * 配置允许跨域（浏览器）
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("*") //options,get
                .maxAge(3600);//3600秒

    }
}
