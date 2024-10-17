package com.wq.elasticjob;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ZedJob implements SimpleJob {
    private static final Logger logger = LoggerFactory.getLogger(ZedJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.info("我是影流之主 Zed");
    }
}
