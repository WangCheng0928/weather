package com.wang.spring.clound.weather.vo;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author: wangcheng
 * @Date: Created in 11:14 2018/6/7
 */
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)  //按照字段访问
@Getter
@Setter
public class City {

    @XmlAttribute(name = "d1")
    private String cityId;
    @XmlAttribute(name = "d2")
    private String cityName;
    @XmlAttribute(name = "d3")
    private String cityCode;
    @XmlAttribute(name = "d4")
    private String province;
}
