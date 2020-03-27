package com.huyi.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "serviceproducer",fallback = FeignFallback.class)
public interface HelloInterface {
    @RequestMapping("/producer/hello")
    public String hello(@RequestParam("name") String name);
}
