package com.example;

import org.springframework.cloud.zookeeper.ZookeeperProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class config {

    @Configuration
    public class ZookeeperConfig {
        @Bean
        public ZookeeperProperties zookeeperProperties() {
            ZookeeperProperties properties = new ZookeeperProperties();
            properties.setConnectString("192.168.80.200:2181");
            return properties;
        }
    }

}
