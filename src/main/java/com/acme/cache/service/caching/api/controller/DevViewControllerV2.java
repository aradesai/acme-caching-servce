package com.acme.cache.service.caching.api.controller;

import com.acme.cache.service.caching.dal.DeveloperDaoV2;
import com.acme.cache.service.caching.model.DevFormModelV2;
import com.acme.cache.service.caching.model.GenderV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;

@Controller
public class DevViewControllerV2 {

    private final DeveloperDaoV2 developerDao;

    @Autowired
    public DevViewControllerV2(DeveloperDaoV2 developerDao) {
        this.developerDao = developerDao;
    }

    @GetMapping(path = "/add-dev")
    public ModelAndView addDevView() {
        ModelAndView modelAndView = new ModelAndView("save");
        modelAndView.addObject("devFormModel", new DevFormModelV2());
        modelAndView.addObject("genders", new HashSet<>(Arrays.asList(GenderV2.values())));
        return modelAndView;
    }

    @GetMapping(path = "/list-dev")
    public ModelAndView addDevService() {
        ModelAndView modelAndView = new ModelAndView("dev-list");
        modelAndView.addObject("devList", developerDao.findAll());
        return modelAndView;
    }
}
