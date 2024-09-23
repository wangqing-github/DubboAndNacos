package com.wq.dubbo;

import com.wq.api.ApiService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class ApiDubboService implements ApiService {
    @Override
    public void accountToApi(String value) {
        System.out.println(value);
    }
}
