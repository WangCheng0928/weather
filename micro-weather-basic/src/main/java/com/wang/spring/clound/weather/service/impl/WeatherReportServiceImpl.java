package com.wang.spring.clound.weather.service.impl;

import com.wang.spring.clound.weather.service.WeatherDataService;
import com.wang.spring.clound.weather.service.WeatherReportService;
import com.wang.spring.clound.weather.vo.Weather;
import com.wang.spring.clound.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangcheng
 * @Date: Created in 15:52 2018/6/7
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    public Weather getDataByCityId(String cityId){
        WeatherResponse weatherResponse = weatherDataService.getDataByCityId(cityId);
        return weatherResponse.getData();
    }

    public Weather getDataByCityName(String cityName){
        WeatherResponse weatherResponse = weatherDataService.getDataByCityName(cityName);
        return weatherResponse.getData();
    }
}
