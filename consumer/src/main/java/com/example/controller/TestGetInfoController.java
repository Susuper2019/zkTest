package com.example.controller;

import com.example.feign.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping
@RestController
public class TestGetInfoController {
    @Autowired
    InfoService infoService;

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping(value = "/test")
    public User getInfo() {
        User info = infoService.getInfo();
        return info;
    }

    @GetMapping(value = "/service")
    public ServiceInstance getService() {
        ServiceInstance choose = loadBalancerClient.choose("info-service");
        List<ServiceInstance> instances = discoveryClient.getInstances("info-service");
        return choose;
    }
}
