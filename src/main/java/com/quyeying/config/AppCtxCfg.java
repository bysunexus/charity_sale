package com.quyeying.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;


/**
 * User: bysun
 * Date: 2014/5/28 0028
 * Time: 15:33
 * spring 主配置文件
 */
@Configuration
@ComponentScan(
    basePackages = "com.quyeying.charity",
    excludeFilters = @ComponentScan.Filter({Controller.class, ControllerAdvice.class}))
@PropertySource(name = "appProperties", value = "classpath:app.properties")
public class AppCtxCfg {

}
