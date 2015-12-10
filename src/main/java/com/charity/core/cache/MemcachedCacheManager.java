/*
 * quyeying.com Copyright (c) 2015.
 */

package com.charity.core.cache;

import net.spy.memcached.MemcachedClient;
import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * Created by bysun on 2015/3/22.
 */
public class MemcachedCacheManager extends AbstractCacheManager {
    private MemcachedClient client;
    private Collection<? extends Cache> caches;

    public void setClient(MemcachedClient client) {
        this.client = client;
    }

    public void setCaches(Collection<? extends Cache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }

    @Override
    public synchronized Cache getCache(String name) {
        Cache cache = super.getCache(name);
        if (cache == null) {
            cache = new MemcachedCache(name, client);
            super.addCache(cache);
        }
        return cache;
    }
}
