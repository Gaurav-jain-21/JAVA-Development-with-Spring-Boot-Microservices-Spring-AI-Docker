package com.gaurav.springmvcboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/add")
    public String add(HttpServletRequest req){
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int num3 = i+j;
        HttpSession session= req.getSession();
        session.setAttribute("result", num3);
        return "result";
    }

}
