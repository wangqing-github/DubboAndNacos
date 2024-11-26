package quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

//禁止并发执行
@DisallowConcurrentExecution
//更新JobDataMap 副本
@PersistJobDataAfterExecution
public class ZedJob extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(ZedJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("我是ZedJob");
    }
}
