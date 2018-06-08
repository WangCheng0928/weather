package com.wang.spring.clound.weather.service.impl;

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

    public Weather getDataByCityId(String cityId){
        //todo 改为由天气数据API微服务来提供
        Weather data = new Weather();
        data.setAqi("81");
        data.setCity("深圳");
        data.setGanmao("容易感冒,多穿衣");
        data.setWendu("22");
        List<Forecast> forecastList = new ArrayList<>();
        Forecast forecast = new Forecast();
        forecast.setDate("29日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("最高温11度");
        forecast.setLow("最低温-1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("28日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("最高温11度");
        forecast.setLow("最低温-1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("27日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("最高温11度");
        forecast.setLow("最低温-1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("26日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("最高温11度");
        forecast.setLow("最低温-1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("25日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("最高温11度");
        forecast.setLow("最低温-1度");
        forecastList.add(forecast);
        data.setForecast(forecastList);
        return data;
    }

}
