package com.wang.spring.clound.weather.config;

import com.wang.spring.clound.weather.common.Const;
import com.wang.spring.clound.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wangcheng
 * @Date: Created in 10:35 2018/6/7
 */
@Configuration
public class QuartzConfiguration {

    //JobDetail 定义一个Job
    @Bean
    public JobDetail weatherSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherJob").storeDurably().build();
    }

    //Trigger  怎么触发
    @Bean
    public Trigger weatherSyncTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(Const.Weather_Trigger_Time).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherSyncJobDetail()).withIdentity("weatherTrigger")
                .withSchedule(scheduleBuilder).build();
    }

}
