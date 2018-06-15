package com.wang.spring.clound.weather.service;

import com.wang.spring.clound.weather.vo.WeatherResponse;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: wangcheng
 * @Date: Created in 12:34 2018/6/10
 */
@FeignClient("msa-weather-data-eureka")
public interface WeatherDataClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
