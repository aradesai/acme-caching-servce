package com.acme.cache.service.caching.api.controller;


import com.acme.cache.service.caching.dal.DeveloperDaoV2;
import com.acme.cache.service.caching.pojo.DevConverterV2;
import com.acme.cache.service.caching.model.DevEntityV2;
import com.acme.cache.service.caching.model.DevFormModelV2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class DevRestControllerV2 {

    private final DeveloperDaoV2 developerDao;
    private final DevConverterV2 devConverter;

    public DevRestControllerV2(DeveloperDaoV2 developerDao, DevConverterV2 devConverter) {
        this.developerDao = developerDao;
        this.devConverter = devConverter;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public RedirectView addDev(@ModelAttribute DevFormModelV2 dev) {
        if (dev == null) {
            throw new IllegalArgumentException("Empty dev");
        }
        DevEntityV2 devEntity = devConverter.convertFormToEntity(dev);
        developerDao.save(devEntity);
        return new RedirectView("/");
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public RedirectView removeDev(@RequestBody Long devId) {
        if (devId == null) throw new IllegalArgumentException("Empty dev Id");
        developerDao.deleteById(devId);
        return new RedirectView("/");

    }

}
