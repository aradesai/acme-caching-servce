package com.acme.cache.service.databasing.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataGeneratorController {

    @RequestMapping(path = "/db/generate-buildings", method = RequestMethod.GET)
    public ModelAndView generateRandomDataForm(){
        return new ModelAndView("buildings-generator");
    }

}
