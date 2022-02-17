package com.acme.cache.service.caching.api.controller;

import com.acme.cache.service.caching.service.ManualClearCacheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ClearCacheRestControllerV2 {

    private final ManualClearCacheService manualClearCacheService;

    public ClearCacheRestControllerV2(ManualClearCacheService manualClearCacheService) {
        this.manualClearCacheService = manualClearCacheService;
    }

    @RequestMapping(path = "clear")
    public RedirectView clearCacheEndpoint(){
        manualClearCacheService.clearCache();
        return new RedirectView("/");
    }
}
