package com.example;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyDisvoeryClient implements DiscoveryClient {

    static List<ServiceInstance> serviceInstances = new ArrayList<>();

    static {
        serviceInstances.add(new ServiceInstance() {
            @Override
            public String getServiceId() {
                return "info-service";
            }

            @Override
            public String getHost() {
                return "localhost";
            }

            @Override
            public int getPort() {
                return 8080;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public URI getUri() {
                return URI.create("http://localhost:8080");
            }

            @Override
            public Map<String, String> getMetadata() {
                return Map.of();
            }
        });
    }

    @Override
    public String description() {
        return "my discovery client";
    }

    @Override
    public List<ServiceInstance> getInstances(String serviceId) {
        return serviceInstances;
    }

    @Override
    public List<String> getServices() {
        return List.of("info-service");
    }
}
