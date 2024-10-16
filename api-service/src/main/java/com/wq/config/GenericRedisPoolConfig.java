package com.wq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class GenericRedisPoolConfig {
    private String host;
    private int port;
    private int database;
    private long timeout;
}
