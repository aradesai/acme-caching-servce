package com.acme.cache.service.caching.configuration;


import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("eh")
@Configuration
@EnableCaching
public class EhCacheSpringCacheConfigV2 {

    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("ehh");
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setMaxEntriesLocalHeap(1000);
        cacheConfiguration.setTimeToLiveSeconds(30);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addDefaultCache(cacheConfiguration);
        net.sf.ehcache.CacheManager cacheManager = net.sf.ehcache.CacheManager.newInstance(config);
        cacheManager.addCache("devs");
        cacheManager.addCache("color");
        return cacheManager;
    }

    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }
}
