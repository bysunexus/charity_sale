/*
 * quyeying.com Copyright (c) 2015.
 */

package com.charity.core.cache;

import net.spy.memcached.MemcachedClient;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

/**
 * Created by bysun on 2015/3/22.
 */
public class MemcachedCache implements Cache {
    private int expire = 24 * 60 * 60;
    private String name;
    private MemcachedClient client;

    public MemcachedCache() {
    }

    public MemcachedCache(String name, MemcachedClient client) {
        this.name = name;
        this.client = client;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return client;
    }

    @Override
    public ValueWrapper get(Object key) {
        String ckey = toStringWithCacheName(key);
        Object value = client.get(ckey);
        return value != null ? new SimpleValueWrapper(value) : null;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        String ckey = toStringWithCacheName(key);
        Object value = client.get(ckey);
        if(value != null && type != null && !type.isInstance(value)) {
            throw new IllegalStateException("Cached value is not of required type [" + type.getName() + "]: " + value);
        } else {
            return (T)value;
        }
    }

    @Override
    public void put(Object key, Object value) {
        if(null == value)
            return;

        String ckey = toStringWithCacheName(key);
        client.set(ckey, expire, value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        if(null == value)
            return null;

        String ckey = toStringWithCacheName(key);
        Object v = client.get(ckey);
        if(null == v){
            v = value;
            put(key,v);

        }

        return  new SimpleValueWrapper(v);
    }

    @Override
    public void evict(Object key) {
        String ckey = toStringWithCacheName(key);
        client.delete(ckey);
    }

    @Override
    public void clear() {
        // 简单粗暴
        client.flush();
    }

    private String toStringWithCacheName(Object obj) {
        return name + "." + String.valueOf(obj);
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemcachedClient getClient() {
        return client;
    }

    public void setClient(MemcachedClient client) {
        this.client = client;
    }
}