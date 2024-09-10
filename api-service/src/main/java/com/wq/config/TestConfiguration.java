package com.wq.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@RefreshScope
public class TestConfiguration {
    @Value("${wq.name}")
    private String name;
    @Value("${wq.age}")
    private int age;
    @Value("${city.cityName}")
    private String cityName;
    @Value("${mail.address}")
    private String address;
}
