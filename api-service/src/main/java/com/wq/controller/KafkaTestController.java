package com.wq.controller;

import com.wq.beans.SimpleMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/mqtest")
public class KafkaTestController {
    private static final Logger logger = LoggerFactory.getLogger(KafkaTestController.class);
    @Autowired
    private StreamBridge streamBridge;

    @RequestMapping("/test1")
    public void testOne() {
        Message<SimpleMsg> msg = new GenericMessage<>(new SimpleMsg("我是 broadcastMessage", new Date().toString()));
        streamBridge.send("broadcastMessage-out-0", msg);
    }

    @RequestMapping("/test2")
    public void testTwo() {
        Message<SimpleMsg> msg = new GenericMessage<>(new SimpleMsg("我是 delayMessage", new Date().toString()));
        logger.info("发送消息：我是 delayMessage");
        streamBridge.send("delayMessage-out-0", msg);
    }
}
