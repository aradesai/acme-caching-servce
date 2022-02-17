package com.acme.cache.service.caching.dal;

import com.acme.cache.service.caching.model.DevEntityV2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperDaoV2 extends JpaRepository<DevEntityV2, Long> {

    @Override
    @Cacheable(value = "devs")
    List<DevEntityV2> findAll();
}
