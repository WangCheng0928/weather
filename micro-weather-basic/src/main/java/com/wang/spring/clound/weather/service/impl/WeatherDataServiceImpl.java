package com.wang.spring.clound.weather.service.impl;

import com.wang.spring.clound.weather.service.WeatherDataService;
import com.wang.spring.clound.weather.util.JsonUtil;
import com.wang.spring.clound.weather.util.SpringJedisUtil;
import com.wang.spring.clound.weather.vo.Weather;
import com.wang.spring.clound.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wangcheng
 * @Date: Created in 11:55 2018/6/4
 */
@Slf4j
@Service("IWeatherDataService")
public class WeatherDataServiceImpl implements WeatherDataService{

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final Long TIME_OUT = 20L; //实际1800s
    private static final int Jedis_Time_out = 60;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SpringJedisUtil springJedisUtil;

    public WeatherResponse getDataByCityId(String cityId){
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    public WeatherResponse getDataByCityName(String cityName){
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    public WeatherResponse getDataByCityNameWithJedis(String cityName){
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeatherJedis(uri);
    }

    private WeatherResponse doGetWeather(String uri){
        String key = uri;
        WeatherResponse weatherResponse = null;
        String respBody = null;
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //先查缓存,缓存有的取缓存中的数据
        if (redisTemplate.hasKey(key)){
            log.info("Redis has data");
            respBody = ops.get(key);
        }else {
            log.info("Redis don't has data");
            //缓存没有,再调用服务接口来获取
            ResponseEntity<String> respStr = restTemplate.getForEntity(uri, String.class);
            if (respStr.getStatusCodeValue() == 200){
                respBody = respStr.getBody();
            }
            //数据写入缓存
            ops.set(key, respBody, TIME_OUT, TimeUnit.SECONDS);
        }
        weatherResponse = JsonUtil.string2Obj(respBody, WeatherResponse.class);
        return weatherResponse;
    }

    private WeatherResponse doGetWeatherJedis(String uri){
        String key = uri;
        WeatherResponse weatherResponse = null;
        String respBody = null;

        //先查缓存,缓存有的取缓存中的数据
        if (springJedisUtil.haskey(key)){
            log.info("Jedis has data");
            respBody = springJedisUtil.get(key);
        }else {
            log.info("Redis don't has data");
            //缓存没有,再调用服务接口来获取
            ResponseEntity<String> respStr = restTemplate.getForEntity(uri, String.class);
            if (respStr.getStatusCodeValue() == 200){
                respBody = respStr.getBody();
            }
            //数据写入缓存
            springJedisUtil.setex(key, respBody, Jedis_Time_out);
        }
        weatherResponse = JsonUtil.string2Obj(respBody, WeatherResponse.class);
        return weatherResponse;
    }

}
