package com.quyeying.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.IOException;
import java.util.Properties;


/**
 * User: bysun
 * Date: 2014/5/28 0028
 * Time: 15:33
 * spring 主配置文件
 */
@Configuration
@ComponentScan(
    basePackages = "com.quyeying.charity",
    excludeFilters=@ComponentScan.Filter({Controller.class,ControllerAdvice.class}))
public class AppCtxCfg {

    @Bean(name={"appProperties"})
    public Properties appProperties() throws IOException {
        PropertiesFactoryBean pfb = new PropertiesFactoryBean();
        pfb.setLocation(new ClassPathResource("app.properties"));
        pfb.setSingleton(true);
        pfb.afterPropertiesSet();
        return pfb.getObject();
    }
}
