package com.wq.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wq.beans.Account;
import com.wq.mapper.AccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountLogicServiceImpl extends ServiceImpl<AccountMapper,Account> implements AccountLogicService{
    private static final Logger logger = LoggerFactory.getLogger(AccountLogicServiceImpl.class);
    @Resource
    AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        accountMapper.insert(new Account("张三"));
        return new ArrayList<>();
    }
}
