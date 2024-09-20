package com.wq.service.impl;

import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wq.account.AccountService;
import com.wq.beans.UserInfo;
import com.wq.mapper.UserInfoMapper;
import com.wq.service.UserInfoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @PostConstruct
    public void initRule() {
        //熔断规则： 5s内调用接口出现异常次数超过5的时候, 进行熔断
        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource("testSentinel");
        rule.setCount(5);
        //统计时长
        rule.setStatIntervalMs(5000);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);//熔断规则
        //熔断时长
        rule.setTimeWindow(10);
        degradeRules.add(rule);
        DegradeRuleManager.loadRules(degradeRules);
    }

    @Override
    public void insert(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        accountService.apiToAccount("api->account");
    }

    @Override
    @SentinelResource(value = "testSentinel", blockHandler = "testBlockHandler", fallback = "testFallback")
    public void testSentinel() {
        System.out.println("testSentinel");
        int a = 1/0;
    }

    public void testBlockHandler(BlockException ex) {
        System.out.println("进入testBlockHandler");
    }

    public void testFallback(Throwable e) {
        System.out.println("进入testFallback");
//        e.printStackTrace();
    }
}
