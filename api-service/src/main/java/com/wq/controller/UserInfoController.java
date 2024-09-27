package com.wq.controller;


import com.wq.beans.SimpleMsg;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wq
 * @since 2022-05-19
 */
@RestController
@RequestMapping("/user-info")
public class UserInfoController {
    @Autowired
    private StreamBridge streamBridge;

    @RequestMapping("/wq")
    public void testOne() {
        String key = "KEY";
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_KEYS, key);
        headers.put(MessageConst.PROPERTY_ORIGIN_MESSAGE_ID, 1);
        Message<SimpleMsg> msg = new GenericMessage<>(new SimpleMsg("broadcastMessage"), headers);
        streamBridge.send("broadcastMessage-out-0", msg);
    }
}

