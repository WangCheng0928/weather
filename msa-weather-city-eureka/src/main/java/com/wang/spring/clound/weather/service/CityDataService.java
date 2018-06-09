package com.wang.spring.clound.weather.service;

import com.wang.spring.clound.weather.vo.City;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 11:38 2018/6/7
 */
public interface CityDataService {
    List<City> listCity() throws Exception;
}
