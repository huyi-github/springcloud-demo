package com.huyi.controller;

import com.huyi.api.FeignFallback;
import com.huyi.api.HelloInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/")
public class HelloController{

    @Autowired
   private RestTemplate restTemplate;

    @Autowired
    private FeignFallback feignFallback;


    @RequestMapping("hello")
    @HystrixCommand(fallbackMethod = "hystrixFallbackMethod")
    public String hello(@RequestParam("name")String name){
       return "hello"+name+"from consumer";
      //return feignFallback.hello(name);
    }

    public String hystrixFallbackMethod(String name){
        return "调用失败1111";
    }
}
