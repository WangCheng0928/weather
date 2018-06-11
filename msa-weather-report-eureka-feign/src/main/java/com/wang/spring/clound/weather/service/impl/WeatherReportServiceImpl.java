package com.wang.spring.clound.weather.service.impl;

import com.wang.spring.clound.weather.service.WeatherDataClient;
import com.wang.spring.clound.weather.service.WeatherReportService;
import com.wang.spring.clound.weather.vo.Forecast;
import com.wang.spring.clound.weather.vo.Weather;
import com.wang.spring.clound.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 15:52 2018/6/7
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataClient weatherDataClient;

    public Weather getDataByCityId(String cityId){

        //由天气数据API微服务来提供
        WeatherResponse weatherResponse = weatherDataClient.getDataByCityId(cityId);
        Weather data = weatherResponse.getData();
        return data;
    }
}
