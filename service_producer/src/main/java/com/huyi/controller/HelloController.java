package com.huyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/producer/")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("hello")
    public String hello(@RequestParam("name")String name){
        System.err.println("producer hrllo");
        return "hello"+name+"from producer";
    }
}
