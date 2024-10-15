package com.project.backendapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class WebController {
    @GetMapping("/hello")
    public String greeting(){
        return "Hello World";
    }
    @GetMapping("/well-come")
    public String wellCome(){
        return "Welcome to Spring Boot";
    }
}
