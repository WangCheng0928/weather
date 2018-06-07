package com.wang.spring.clound.weather.job;

import com.wang.spring.clound.weather.service.CityDataService;
import com.wang.spring.clound.weather.service.WeatherDataService;
import com.wang.spring.clound.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 10:34 2018/6/7
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("Weather Data Sync Job Start");
        //获取城市Id列表
        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            log.error("Exception!", e);
        }
        //遍历城市ID获取天气
        for (City city : cityList){
            String cityId = city.getCityId();
            log.info("Weather Data Sync Job: " + cityId);
            weatherDataService.syncDataByCityId(cityId);
        }
        log.info("Weather Data Sync Job End!");
    }
}
