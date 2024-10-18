package com.wq.xxljob;

import com.xxl.job.core.context.XxlJobContext;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class XxlJobFactory {
    private static Logger logger = LoggerFactory.getLogger(XxlJobFactory.class);

    @XxlJob("zedJobTest")
    public void zedJobTest() {
        logger.info("这是zedJobTest");
    }

    /**
     * 2、分片广播任务
     */
    @XxlJob("shardingJobHandler")
    public void shardingJobHandler(String param) throws Exception {
        int shardTotal = XxlJobHelper.getShardTotal();
        int index = XxlJobHelper.getShardIndex();
        logger.info("总共：{}个分片，当前的index为：{}", shardTotal, index);
    }
}
