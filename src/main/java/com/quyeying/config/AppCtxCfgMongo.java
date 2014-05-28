package com.quyeying.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * User: bysun
 * Date: 2014/5/28 0028
 * Time: 16:27
 */
@Configuration
public class AppCtxCfgMongo extends AbstractMongoConfiguration {

    @Resource(name="appProperties")
    private Properties appProperties;
    @Override
    @Bean
    protected String getDatabaseName() {
        return appProperties.getProperty("db.mongo.dbbame");
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(appProperties.getProperty("db.mongo.dbaddr"));
    }
}
