package com.wq.dubbo;

import com.wq.account.AccountService;
import com.wq.beans.Account;
import com.wq.service.AccountLogicService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

@DubboService
public class AccountDubboService implements AccountService {
    @Resource
    AccountLogicService accountLogicService;

    @Override
    public void testDubbo(String value) {
        System.out.println(value);
//        List<Account> list1 = accountLogicService.list();
        List<Account> list = accountLogicService.findAll();
        System.out.println(list);
    }
}
