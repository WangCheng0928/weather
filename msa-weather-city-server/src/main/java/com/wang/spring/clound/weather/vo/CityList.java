package com.wang.spring.clound.weather.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 11:18 2018/6/7
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)  //按照字段访问
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
