package com.example.demo.config;

import com.example.demo.interceptor.DemoInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 添加资源映射路径
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("[WebMvcConfiguration] WebMvc addResourceHandlers");
//        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
//        registry.addResourceHandler("/api_files/**").addResourceLocations("file:D:/data/api_files");
        super.addResourceHandlers(registry);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
