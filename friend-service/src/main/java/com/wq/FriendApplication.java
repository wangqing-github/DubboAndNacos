package com.wq;

import com.wq.beans.SimpleMsg;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@SpringBootApplication(scanBasePackages = {"com.wq"})
@EnableDubbo(scanBasePackages = "com.wq")
public class FriendApplication {
    private static final Logger log = LoggerFactory.getLogger(FriendApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(FriendApplication.class, args);
    }

    @Bean
    public Consumer<Message<SimpleMsg>> broadcastMessage() {
        return msg -> {
            log.info(Thread.currentThread().getName() + " Consumer2 Receive New Messages: " + msg.getPayload().getMsg());
        };
    }

    @Bean
    public Consumer<Message<SimpleMsg>> delayMessage() {
        return msg -> {
            log.info(Thread.currentThread().getName() + " Consumer Receive New Messages: " + msg.getPayload().getMsg());
        };
    }
}
