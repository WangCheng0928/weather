package com.wang.spring.clound.weather.service.impl;

import com.wang.spring.clound.weather.service.CityDataService;
import com.wang.spring.clound.weather.util.XmlBuilder;
import com.wang.spring.clound.weather.vo.City;
import com.wang.spring.clound.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 11:39 2018/6/7
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    //获取城市列表
    public List<City> listCity() throws Exception {
        //读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null){
            buffer.append(line);
        }
        br.close();
        //XML转为java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
