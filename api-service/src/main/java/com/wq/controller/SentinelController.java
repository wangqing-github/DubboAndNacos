package com.wq.controller;

import com.wq.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/testSentinel")
public class SentinelController {

    @Resource
    UserInfoService userInfoService;

    @RequestMapping("/one")
    public void testThree() {
        userInfoService.testSentinel();
    }
}
