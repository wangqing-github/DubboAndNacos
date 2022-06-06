package com.wq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wq.beans.UserInfo;
import com.wq.mapper.UserInfoMapper;
import com.wq.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wq
 * @since 2022-05-19
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
