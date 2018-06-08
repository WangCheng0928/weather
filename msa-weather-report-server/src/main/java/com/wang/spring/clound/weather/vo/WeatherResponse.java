package com.wang.spring.clound.weather.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: wangcheng
 * @Date: Created in 11:49 2018/6/4
 */

@Getter
@Setter
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String desc;

}
