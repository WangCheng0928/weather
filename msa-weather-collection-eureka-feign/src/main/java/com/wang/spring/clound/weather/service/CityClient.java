package com.wang.spring.clound.weather.service;

import com.wang.spring.clound.weather.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 12:26 2018/6/10
 */
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    List<City> cityList() throws Exception;
}
