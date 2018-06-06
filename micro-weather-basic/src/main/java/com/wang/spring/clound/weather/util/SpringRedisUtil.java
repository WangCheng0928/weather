package com.wang.spring.clound.weather.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wangcheng
 * @Date: Created in 15:12 2018/6/5
 */
@Component
@Slf4j
public class SpringRedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //写入redis缓存(不设置expire时间)
    public boolean set(String key, String value){
        boolean result = false;
        try {
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            log.error("写入redis缓存失败,错误信息为：" + e.getMessage());
        }
        return  result;
    }

    public boolean set(String key, String value, Long expire){
        boolean result = false;
        try {
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
//            operations.set(key, value, expire, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("写入redis缓存失败(设置缓存时间),错误信息为：" + e.getMessage());
        }
        return  result;
    }

    //判断redis缓存中是否有对应的key
    public boolean exists(String key){
        boolean result = false;
        try {
            result = redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error("读取redis缓存失败,错误信息为：" + e.getMessage());
        }
        return  result;
    }

    //redis根据key删除对应的value
    public boolean remove(String key){
        boolean result = false;
        try {
            if (exists(key)){
                redisTemplate.delete(key);
            }
            result = true;
        } catch (Exception e) {
            log.error("删除redis缓存失败,错误信息为：" + e.getMessage());
        }
        return  result;
    }

    //批量删除对应的value
    public void remove(String... keys){
        for (String key : keys){
            remove(key);
        }
    }
}
