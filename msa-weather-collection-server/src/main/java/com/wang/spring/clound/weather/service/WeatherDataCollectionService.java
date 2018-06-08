package com.wang.spring.clound.weather.service;

/**
 * @Author: wangcheng
 * @Date: Created in 11:16 2018/6/8
 */
public interface WeatherDataCollectionService {

    //根据城市Id同步天气
    void syncDataByCityId(String cityId);
}
