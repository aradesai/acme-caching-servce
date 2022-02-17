package com.acme.cache.service.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex/")
public class ExceptionThrowerController {

    @GetMapping("illegalargument")
    public ResponseEntity<HttpStatus> throwIllegalArgument(Integer number){
        if (number == null ) throw new IllegalArgumentException("Number is null");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
