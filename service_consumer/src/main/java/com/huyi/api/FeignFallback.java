package com.huyi.api;

import com.huyi.api.HelloInterface;
import com.netflix.ribbon.proxy.annotation.Content;
import org.springframework.stereotype.Component;

@Component
public class FeignFallback  implements HelloInterface {
    @Override
    public String hello(String name) {
        return "服务调用失败";
    }
}
