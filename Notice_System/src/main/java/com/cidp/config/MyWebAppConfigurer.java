package com.cidp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 例：  http://localhost:8889/image/Cg-4WlVQcm2If6MdAAT82WzB7C8AADYFAHANTUABPzx218.jpg
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/xyzyxz-files/");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new InterceptConfig()).addPathPatterns("/**").excludePathPatterns("/homePage/*","/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
