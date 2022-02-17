package com.acme.cache.service.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionsIndexController {

    @RequestMapping(path = "ex", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("exceptions-index");
    }

}
