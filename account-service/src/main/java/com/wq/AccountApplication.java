package com.wq;

import com.wq.beans.SimpleMsg;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;


@SpringBootApplication(scanBasePackages = {"com.wq"})
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.wq.mapper"})
public class AccountApplication {
    private static final Logger log = LoggerFactory.getLogger(AccountApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    public Consumer<Message<SimpleMsg>> broadcastMessage() {
        return msg -> {
            log.info(Thread.currentThread().getName() + " Consumer1 Receive New Messages: " + msg.getPayload().getMsg() + msg.getPayload().getTime());
        };
    }

    @Bean
    public Consumer<Message<SimpleMsg>> delayMessage() {
        return msg -> {
            log.info(Thread.currentThread().getName() + " Consumer Receive New Messages: " + msg.getPayload().getMsg());
        };
    }
}
