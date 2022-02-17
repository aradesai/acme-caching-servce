package com.acme.cache.service.caching.configuration;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("caffeine")
@ContextConfiguration(classes = {CaffeineCacheConfigV2.class, CaffeineCacheConfigTest.InnerConfig.class})
public class CaffeineCacheConfigTest {

    @Autowired
    private InnerConfig.MockedBean mockedBean;

    @Configuration
    static class InnerConfig {

        @Bean
        MockedBean mockedBean() {
            return new MockedBean();
        }

        class MockedBean {
            /*
            * Caffeine loads cache names from app, doesn't needs pre-configured names
            * */
            @Cacheable("test")
            public Object testCache(int number) {
                return new Object();
            }
        }
    }

    @Test
    public void shouldCacheData() {
        //given
        Object objectA = new Object();
        Object objectB = new Object();
        Object objectC = new Object();
        //when
        objectA = mockedBean.testCache(1);
        objectB = mockedBean.testCache(1);
        objectC = mockedBean.testCache(2);
        //then
        Assertions.assertThat(objectA).isEqualTo(objectB);
        Assertions.assertThat(objectA).isNotEqualTo(objectC);

    }

}