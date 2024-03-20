package com.example.project20thang3.controller;


import com.example.project20thang3.request.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @PostMapping("/user")
    public String helloUser(@RequestBody User body)
    {
        System.out.printf(body.getAge());
        return body.getName();
    }
}
