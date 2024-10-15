package com.wq.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ZedJob extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(ZedJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        logger.info("幼年是盼盼，青年是晶晶，中年是冰墩墩，生活见好逐渐发福");
    }
}
