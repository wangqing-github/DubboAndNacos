package com.wq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wq.account.AccountService;
import com.wq.beans.UserInfo;
import com.wq.mapper.UserInfoMapper;
import com.wq.service.UserInfoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wq
 * @since 2022-05-19
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @DubboReference(mock = "com.wq.dubbo.mock.AccountServiceMock")
    AccountService accountService;
    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public void insert(UserInfo userInfo) {
//        userInfoMapper.insert(userInfo);
        accountService.apiToAccount("api->account");
    }

}
