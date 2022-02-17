package com.acme.cache.service.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller("secure")
public class SecurityIndexController {

    @GetMapping
    public ModelAndView indexGet() {
        return new ModelAndView("security-index");
    }

    @PostMapping
    public ModelAndView indexPost(HttpSession httpSesion) {
        ModelAndView modelAndView = new ModelAndView("security-index");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String info = "NoName";
        if (principal instanceof UserDetails) {
            info = "You successfully logged as: " + ((UserDetails) principal).getUsername();
        } else {
            info = principal.toString();
        }
        modelAndView.addObject("info", info);
        return modelAndView;
    }
}
