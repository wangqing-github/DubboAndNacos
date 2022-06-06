package com.wq.controller;

import com.wq.account.AccountService;
import com.wq.api.ApiService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class AccountController {

    @DubboReference(mock = "com.wq.dubbo.mock.ApiServiceMock")
    ApiService apiService;

    @RequestMapping("/accountTest")
    public void test() {
        apiService.apiTestDubbo("account -> api");
    }
}
