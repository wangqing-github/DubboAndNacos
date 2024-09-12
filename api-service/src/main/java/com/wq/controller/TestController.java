package com.wq.controller;

import com.wq.account.AccountService;
import com.wq.beans.UserInfo;
import com.wq.config.TestConfiguration;
import com.wq.service.UserInfoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    UserInfoService userInfoService;
    @Autowired
    TestConfiguration testConfiguration;
    @RequestMapping("/testOne")
    public void test() {
        System.out.println(testConfiguration.getName());
    }

    @RequestMapping("/testTwo")
    public void testTwo() {
        userInfoService.insert(new UserInfo("李四"));
    }
}
