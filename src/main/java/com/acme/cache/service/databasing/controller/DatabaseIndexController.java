package com.acme.cache.service.databasing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DatabaseIndexController {

    @GetMapping(value = "/db/databasing")
    public ModelAndView loadDatabasingWebIndex() {
        ModelAndView modelAndView = new ModelAndView("databasing-index");
        return modelAndView;
    }
}
