package com.wang.spring.clound.weather.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: wangcheng
 * @Date: Created in 11:32 2018/6/4
 */

@Getter
@Setter
public class Forecast implements Serializable {

    private static final long serialVersionUID = 1L;
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

}
