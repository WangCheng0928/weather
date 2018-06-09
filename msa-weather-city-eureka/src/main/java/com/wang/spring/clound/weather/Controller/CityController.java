package com.wang.spring.clound.weather.Controller;

import com.wang.spring.clound.weather.service.CityDataService;
import com.wang.spring.clound.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 15:53 2018/6/8
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @RequestMapping("")
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
