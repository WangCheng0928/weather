package com.wang.spring.clound.weather.controller;

import com.wang.spring.clound.weather.service.CityDataService;
import com.wang.spring.clound.weather.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: wangcheng
 * @Date: Created in 16:09 2018/6/7
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherReportService weatherReportService;

    @RequestMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId")String cityId, Model model) throws Exception {
        model.addAttribute("title", "老王的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

    @RequestMapping("/cityName/{cityName}")
    public ModelAndView getReportByCityName(@PathVariable("cityName")String cityName, Model model) throws Exception {
        model.addAttribute("title", "老王的天气预报");
        model.addAttribute("cityName", cityName);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityName(cityName));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
