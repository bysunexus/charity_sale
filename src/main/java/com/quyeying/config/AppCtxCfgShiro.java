package com.quyeying.config;

import com.quyeying.security.UserMongoRepository;
import com.quyeying.security.ShiroMetaSource;
import com.quyeying.security.ShiroMongoRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * User: bysun
 * Date: 2014/5/28 0028
 * Time: 15:33
 * spring 主配置文件
 */
@Configuration
public class AppCtxCfgShiro{

    @Autowired
    UserMongoRepository userMongoRepository;


    private ShiroMongoRealm getShiroMongoRealm(){
        ShiroMongoRealm bean = new ShiroMongoRealm();
        bean.setRepo(userMongoRepository);
        return bean;
    }

    private EhCacheManager getEhCacheManager(){
        EhCacheManager bean = new EhCacheManager();
        bean.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return bean;
    }

    private DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager bean = new DefaultWebSecurityManager();

        bean.setRealm(getShiroMongoRealm());
        bean.setCacheManager(getEhCacheManager());
        return bean;
    }

    private ShiroMetaSource getShiroMetaSource(){
        ShiroMetaSource bean = new ShiroMetaSource();
        bean.setRepo(userMongoRepository);
        return bean;
    }

    @Bean(name = "shiroFilter")
    public AbstractShiroFilter getShiroFilter() throws Exception {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(getDefaultWebSecurityManager());
        factoryBean.setLoginUrl("/login");
        factoryBean.setUnauthorizedUrl("/unauthorized");
        factoryBean.setFilterChainDefinitionMap(getShiroMetaSource().getObject());


        return (AbstractShiroFilter)factoryBean.getObject();
    }

    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
}
