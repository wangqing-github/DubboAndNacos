package com.wq.controller;

import com.wq.beans.UserInfo;
import com.wq.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    UserInfoService userInfoService;

    @RequestMapping("/testOne")
    public void test() {
    }

    @RequestMapping("/testTwo")
    public void testTwo() {
        userInfoService.insert(new UserInfo("李四"));
    }

}
