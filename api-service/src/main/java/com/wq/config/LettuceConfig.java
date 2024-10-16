package com.wq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis.lettuce.pool")
public class LettuceConfig {
    private int maxActive;
    private int maxIdle;
    private int minIdle;
    private int maxWait;
}
