package com.acme.cache.service.caching.api.controller;

import com.acme.cache.service.caching.service.RandomColorGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ColorViewControllerV2 {

    private RandomColorGeneratorService randomColorGeneratorService;

    public ColorViewControllerV2(RandomColorGeneratorService randomColorGeneratorService) {
        this.randomColorGeneratorService = randomColorGeneratorService;
    }

    @RequestMapping(path = "/color", method = RequestMethod.GET)
    public ModelAndView randomColor(@RequestParam("button") int buttonNumber) {
        ModelAndView modelAndView = new ModelAndView("color");
        Integer[] rgb = randomColorGeneratorService.generateRandomRGB(buttonNumber);
        modelAndView.addObject("red", rgb[0]);
        modelAndView.addObject("green", rgb[1]);
        modelAndView.addObject("blue", rgb[2]);
        return modelAndView;
    }
}
