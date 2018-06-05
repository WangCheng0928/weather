package com.wang.spring.clound.weather.config;

import com.wang.spring.clound.weather.util.RedisObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: wangcheng
 * @Date: Created in 16:00 2018/6/5
 */
@Configuration
public class SpringRedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        RedisObjectSerializer redisObjectSerializer = new RedisObjectSerializer();
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(stringRedisSerializer);
        template.setValueSerializer(redisObjectSerializer);
        return template;
    }
}
