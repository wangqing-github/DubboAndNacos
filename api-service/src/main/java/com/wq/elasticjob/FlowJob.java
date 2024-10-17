package com.wq.elasticjob;

import beans.UserInfo;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.dataflow.job.DataflowJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlowJob implements DataflowJob<UserInfo> {
    private static final Logger logger = LoggerFactory.getLogger(FlowJob.class);

    @Override
    public List<UserInfo> fetchData(ShardingContext shardingContext) {
        List<UserInfo> foos = new ArrayList<>();
        double random = Math.random();
        if (random > 0.5) {
            logger.info("fetchData------ {}", random);
            UserInfo foo = new UserInfo();
            foo.setUserName("小道仙");
            foos.add(foo);
        }
        return foos;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<UserInfo> list) {
        logger.info("收到流数据");
        list.forEach(i -> logger.info("name为：{}", i.getUserName()));
    }
}
