package com.myself.code.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 前端资源配置
 * Created by MySelf on 2018/11/8.
 */
@Configuration
public class PathConfig extends WebMvcConfigurationSupport {

    @Autowired
    private QrCode qrCode;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(qrCode.getHandler()).addResourceLocations(qrCode.getLocation());
        super.addResourceHandlers(registry);
    }
}
