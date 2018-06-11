package com.wang.spring.clound.weather.service;

import com.wang.spring.clound.weather.vo.Weather;

/**
 * @Author: wangcheng
 * @Date: Created in 15:51 2018/6/7
 */
public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}
