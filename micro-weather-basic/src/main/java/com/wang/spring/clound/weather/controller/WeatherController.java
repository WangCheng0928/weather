package com.wang.spring.clound.weather.controller;

import com.wang.spring.clound.weather.service.WeatherDataService;
import com.wang.spring.clound.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcheng
 * @Date: Created in 14:36 2018/6/4
 */

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    //通过城市id查询天气
    @RequestMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    //通过城市名称查询天气
    @RequestMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
        return weatherDataService.getDataByCityNameWithJedis(cityName);
    }

}
