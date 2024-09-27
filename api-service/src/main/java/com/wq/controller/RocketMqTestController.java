package com.wq.controller;

import com.wq.beans.SimpleMsg;
import org.apache.rocketmq.common.message.MessageConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/mqtest")
public class RocketMqTestController {
    private static final Logger logger = LoggerFactory.getLogger(RocketMqTestController.class);
    @Autowired
    private StreamBridge streamBridge;

    @RequestMapping("/test1")
    public void testOne() {
        String key = "KEY1";
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_KEYS, key);
        headers.put(MessageConst.PROPERTY_ORIGIN_MESSAGE_ID, 1);
        Message<SimpleMsg> msg = new GenericMessage<>(new SimpleMsg("broadcastMessage"), headers);
        streamBridge.send("broadcastMessage-out-0", msg);
    }

    @RequestMapping("/test2")
    public void testTwo() {
        String key = "KEY2";
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_KEYS, key);
        headers.put(MessageConst.PROPERTY_ORIGIN_MESSAGE_ID, 1);
        headers.put(MessageConst.PROPERTY_DELAY_TIME_LEVEL, 2);
        Message<SimpleMsg> msg = new GenericMessage<>(new SimpleMsg("我是 delayMessage"), headers);
        //5.x版本后 可以通过下面精确设置延时时间，注意Message的包要import为rocketmq的
//        Message message = new Message();
//        message.setDelayTimeMs(3500);
//        message.setDelayTimeSec(3500);
//        message.setDeliverTimeMs(3500);
        logger.info("发送消息：我是 delayMessage");
        streamBridge.send("delayMessage-out-0", msg);
    }
}
