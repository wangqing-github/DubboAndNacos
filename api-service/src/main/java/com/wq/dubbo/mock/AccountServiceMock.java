package com.wq.dubbo.mock;

import com.wq.account.AccountService;

public class AccountServiceMock implements AccountService {

    @Override
    public void apiToAccount(String value) {
        System.out.println("调用Account失败");
    }
}
