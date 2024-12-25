package com.chan.fileupload.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class  WebMvcConfig implements WebMvcConfigurer {

    String clientPath="/images/**";
    String serverPath="fileStorage/images/";
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(clientPath)
                .addResourceLocations("file:"+serverPath);

    }
}