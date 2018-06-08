package com.wang.spring.clound.weather.service;

import com.wang.spring.clound.weather.vo.WeatherResponse;

/**
 * @Author: wangcheng
 * @Date: Created in 11:54 2018/6/4
 */
public interface WeatherDataService {

    public WeatherResponse getDataByCityId(String cityId);
    public WeatherResponse getDataByCityName(String cityName);
//    WeatherResponse getDataByCityNameWithJedis(String cityName);
}
