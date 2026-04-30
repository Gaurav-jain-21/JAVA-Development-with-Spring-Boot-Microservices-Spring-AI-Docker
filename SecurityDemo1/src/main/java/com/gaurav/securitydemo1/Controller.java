package com.gaurav.securitydemo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/hey")
    public String hey(){
        return "Hey world";
    }

    @GetMapping("/hi")
    public String hi(){
        return "Hi world";
    }
}
