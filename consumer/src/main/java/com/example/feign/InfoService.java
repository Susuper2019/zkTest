package com.example.feign;

import com.example.controller.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "info-service", url = "${feign.info-service.url:}",configuration = FeignConfiguration.class)
public interface InfoService {
    @PostMapping(value = "/info")
    User getInfo();
}
