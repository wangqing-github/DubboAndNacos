package com.wq.controller;

import com.wq.account.AccountService;
import com.wq.service.UserInfoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @DubboReference(mock = "com.wq.dubbo.mock.AccountServiceMock")
    AccountService accountService;
    @Resource
    UserInfoService userInfoService;

    @RequestMapping("/testOne")
    public void test() {
        System.out.println(userInfoService.list());
    }

    @RequestMapping("/testTwo")
    public void testTwo() {
        accountService.testDubbo("api->account");
    }
}
