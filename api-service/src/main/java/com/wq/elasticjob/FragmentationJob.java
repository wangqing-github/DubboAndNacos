package com.wq.elasticjob;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FragmentationJob implements SimpleJob {
    private static final Logger logger = LoggerFactory.getLogger(FragmentationJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.info("分片任务");
        switch (shardingContext.getShardingItem()) {
            case 0:
                logger.info("分片0:{}",shardingContext.getShardingParameter());
                break;
            case 1:
                logger.info("分片1:{}",shardingContext.getShardingParameter());
                break;
            case 2:
                logger.info("分片2:{}",shardingContext.getShardingParameter());
                break;
            default:
                break;
        }
    }
}
