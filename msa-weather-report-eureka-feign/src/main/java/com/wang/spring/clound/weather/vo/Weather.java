package com.wang.spring.clound.weather.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 11:31 2018/6/4
 */

@Getter
@Setter
public class Weather implements Serializable {

    private static final long serialVersionUID = 1L;
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;

}
