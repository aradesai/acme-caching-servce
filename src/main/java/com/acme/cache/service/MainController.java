package com.acme.cache.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping(path = "/")
    public ModelAndView index() {
        return new ModelAndView("main-index");
    }
}
