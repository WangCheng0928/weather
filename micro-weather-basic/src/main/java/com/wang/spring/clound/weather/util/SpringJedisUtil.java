//package com.wang.spring.clound.weather.util;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.JedisCluster;
//
///**
// * @Author: wangcheng
// * @Date: Created in 13:30 2018/6/6
// */
//@Component
//@Slf4j
//public class SpringJedisUtil {
//
//    @Autowired
//    private JedisCluster jedisCluster;
//
//    //设置缓存
//    public void set(String key, String value){
//        try {
//            jedisCluster.set(key, value);
//            log.info("JedisUtil: set key:{}, value:{}", key, value);
//        } catch (Exception e) {
//            log.error("JedisUtil set key:{} value:{} error", key, value, e);
//        }
//    }
//
//    public void setex(String key, String value, int expireTime){
//        try {
//            jedisCluster.setex(key, expireTime, value);
//            log.info("JedisUtil: setex key:{}, value:{}", key, value);
//        } catch (Exception e) {
//            log.error("JedisUtil setex key:{} value:{} error", key, value, e);
//        }
//    }
//
//    public String get(String key){
//        String result = null;
//        try {
//            result = jedisCluster.get(key);
//            log.info("JedisUtil: get key:{}", key);
//        } catch (Exception e) {
//            log.error("JedisUtil get key:{}", key, e);
//        }
//        return result;
//    }
//
//    public Boolean haskey(String key){
//        Boolean result = false;
//        try {
//            result = jedisCluster.exists(key);
//            log.info("JedisUtil: has key:{}", key);
//        } catch (Exception e) {
//            log.error("JedisUtil don't has key:{}", key, e);
//        }
//        return result;
//    }
//
//    public void delete(String key){
//        try {
//            jedisCluster.del(key);
//            log.info("JedisUtil: del key:{}", key);
//        } catch (Exception e) {
//            log.error("JedisUtil del key:{}", key, e);
//        }
//    }
//}
