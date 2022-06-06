package com.wq.dubbo.mock;

import com.wq.api.ApiService;

public class ApiServiceMock implements ApiService {
    @Override
    public void apiTestDubbo(String value) {
        System.out.println("调用API失败");
    }
}
