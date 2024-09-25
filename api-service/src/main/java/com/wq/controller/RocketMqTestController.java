package com.wq.controller;

import com.wq.beans.SimpleMsg;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mqtest")
public class RocketMqTestController {
    @Autowired
    private StreamBridge streamBridge;

//    @Resource
//    private Source source;

    @RequestMapping("/test1")
    public void testTwo() {
        System.out.println(1);
//        source.output().send(MessageBuilder.withPayload(new SimpleMsg("wangqing")).build());
        for (int i = 0; i < 10; i++) {
            String key = "KEY" + i;
            Map<String, Object> headers = new HashMap<>();
            headers.put(MessageConst.PROPERTY_KEYS, key);
            headers.put(MessageConst.PROPERTY_ORIGIN_MESSAGE_ID, i);
            Message<SimpleMsg> msg = new GenericMessage<>(new SimpleMsg("Hello RocketMQ " + i), headers);
            streamBridge.send("producer-out-0", msg);
        }
    }
}
