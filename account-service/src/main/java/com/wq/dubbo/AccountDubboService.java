package com.wq.dubbo;

import com.wq.account.AccountService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class AccountDubboService implements AccountService {
    @Override
    public void testDubbo(String value) {
        System.out.println(value);
    }
}
