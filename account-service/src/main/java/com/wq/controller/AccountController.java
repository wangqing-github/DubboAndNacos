package com.wq.controller;

import com.wq.account.AccountService;
import com.wq.api.ApiService;
import com.wq.service.AccountLogicService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/test")
public class AccountController {

    @Resource
    private AccountLogicService accountLogicService;

    @RequestMapping("/accountTest")
    public void test() {
        accountLogicService.apiTestDubbo("account -> api");
    }
}
