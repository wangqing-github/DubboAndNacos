package com.wq.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quartz.ZedJob;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(ZedJob.class)
                // 指定任务的名称
                .withIdentity("zedJob")
                // 任务描述
                .withDescription("任务描述：用于输出冬奥欢迎语")
                // 每次任务执行后进行存储
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {
        //创建触发器
        SimpleScheduleBuilder simpleScheduleBuilder1 = SimpleScheduleBuilder.repeatSecondlyForever(5);
        return TriggerBuilder.newTrigger()
                // 绑定工作任务
                .withIdentity("zedJob")
                .forJob(jobDetail())
                // 每隔 5 秒执行一次 job
                .withSchedule(simpleScheduleBuilder1)
                .build();
    }
}
