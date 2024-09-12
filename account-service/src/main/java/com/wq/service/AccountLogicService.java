package com.wq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wq.beans.Account;

import java.util.List;

public interface AccountLogicService extends IService<Account> {
    List<Account> findAll();
}
