package com.gaurav.firstlearning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/greet")
    public String greet(){
        System.out.println("hello world");
        return "Welcome to the gaurav world";
    }

    @GetMapping("/about")
    public String about(){
        return "we dont talk anymore lilkw ";
    }
}
