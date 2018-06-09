//package com.wang.spring.clound.weather.config;
//
//import com.wang.spring.clound.weather.util.RedisObjectSerializer;
//import com.wang.spring.clound.weather.util.SpringRedisUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.lang.reflect.Method;
//
///**
// * @Author: wangcheng
// * @Date: Created in 16:00 2018/6/5
// */
//@Configuration
//@EnableCaching
//@AutoConfigureAfter(SpringRedisConfig.class)
//public class SpringRedisConfig extends CachingConfigurerSupport {
//
//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(){
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        RedisObjectSerializer redisObjectSerializer = new RedisObjectSerializer();
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setDefaultSerializer(stringRedisSerializer);
//        redisTemplate.setValueSerializer(redisObjectSerializer);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    @Bean
//    @SuppressWarnings("rawtypes")
//    public CacheManager cacheManager(RedisTemplate redisTemplate){
//        RedisCacheManager redisCacheManager=new RedisCacheManager(redisTemplate);
//        //设置缓存过期时间
////        redisCacheManager.setDefaultExpiration(60);//秒
//        return redisCacheManager;
//    }
//
//    //重写缓存key生成策略，可根据自身业务需要进行自己的配置生成条件
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj : params) {
//                    sb.append(obj.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }
//}
