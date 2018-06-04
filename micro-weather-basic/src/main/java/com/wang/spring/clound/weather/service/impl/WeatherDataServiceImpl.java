package com.wang.spring.clound.weather.service.impl;

import com.wang.spring.clound.weather.service.WeatherDataService;
import com.wang.spring.clound.weather.util.JsonUtil;
import com.wang.spring.clound.weather.vo.Weather;
import com.wang.spring.clound.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: wangcheng
 * @Date: Created in 11:55 2018/6/4
 */
@Service("IWeatherDataService")
public class WeatherDataServiceImpl implements WeatherDataService{

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getDataByCityId(String cityId){
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    public WeatherResponse getDataByCityName(String cityName){
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri){
        WeatherResponse weatherResponse = null;
        String respBody = null;
        ResponseEntity<String> respStr = restTemplate.getForEntity(uri, String.class);
        if (respStr.getStatusCodeValue() == 200){
            respBody = respStr.getBody();
            weatherResponse = JsonUtil.string2Obj(respBody, WeatherResponse.class);
        }
        return weatherResponse;
    }
}
