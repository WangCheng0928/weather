package com.wang.spring.clound.weather.controller;

import com.wang.spring.clound.weather.service.WeatherReportService;
import com.wang.spring.clound.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 16:09 2018/6/7
 */
@RestController
@RequestMapping("/report")
@Slf4j
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @RequestMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId")String cityId, Model model) throws Exception {
        //获取城市Id列表
        //todo 改为由城市数据API微服务来提供数据
        List<City> cityList = null;
        try {
            //todo 改为由城市数据API微服务来提供数据
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280101");
            city.setCityName("深圳");
            cityList.add(city);
        } catch (Exception e) {
            log.error("Exception!", e);
        }
        model.addAttribute("title", "老王的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
