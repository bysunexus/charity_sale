package com.quyeying.config;


import com.quyeying.security.RolesFilter;
import com.quyeying.security.ShiroMetaSource;
import com.quyeying.security.ShiroMongoRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;


/**
 * User: bysun
 * Date: 2014/5/28 0028
 * Time: 15:33
 * spring 主配置文件
 */
@Configuration
public class AppCtxCfgShiro {

    @Bean
    public RolesFilter getRolesFilter() {
        return new RolesFilter();
    }

    @Bean
    public ShiroMongoRealm getShiroMongoRealm() {
        ShiroMongoRealm bean = new ShiroMongoRealm();
        return bean;
    }

    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager bean = new EhCacheManager();
        bean.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return bean;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager bean = new DefaultWebSecurityManager();
        bean.setRealm(getShiroMongoRealm());
        bean.setCacheManager(getEhCacheManager());
        return bean;
    }

    @Bean
    public ShiroMetaSource getShiroMetaSource() {
        ShiroMetaSource bean = new ShiroMetaSource();
        return bean;
    }

    @Bean(name = "shiroFilter")
    public AbstractShiroFilter getShiroFilter() throws Exception {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(getDefaultWebSecurityManager());
        factoryBean.setLoginUrl("/login");
        factoryBean.setUnauthorizedUrl("/unauthorized");
        factoryBean.setFilterChainDefinitionMap(getShiroMetaSource().getObject());
        Map<String, Filter> filters = new HashMap<>();
        filters.put("roleOr", getRolesFilter());
        factoryBean.setFilters(filters);

        return (AbstractShiroFilter) factoryBean.getObject();
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn(value = "lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
