package com.acme.cache.service.caching.api.controller;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CachingIndexControllerV2 {

    private final CacheManager cacheManager;

    public CachingIndexControllerV2(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @GetMapping(path = "/ca/caching")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("caching-index");
        modelAndView.addObject("cacheName", cacheManager.getClass().getSimpleName());
        return modelAndView;
    }
}
