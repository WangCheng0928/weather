package com.wang.spring.clound.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: wangcheng
 * @Date: Created in 11:14 2018/6/7
 */
@Getter
@Setter
@Slf4j
public class City {

    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;
}
