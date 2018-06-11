package com.wang.spring.clound.weather.Controller;

import com.wang.spring.clound.weather.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcheng
 * @Date: Created in 11:33 2018/6/10
 */
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    public String listCity(){
        //通过feign客户端来查找
        String body = cityClient.listCity();
        return body;
    }
}
