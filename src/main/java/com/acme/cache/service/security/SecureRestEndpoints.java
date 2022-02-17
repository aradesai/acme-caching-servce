package com.acme.cache.service.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureRestEndpoints {

    @RequestMapping(value = "/admin-secure")
    public String admin() {
        return "Hello there, Admin!";
    }

    @RequestMapping(value = "/user-secure")
    public String user() {
        return "Hello there, Admin or User!";
    }

}
