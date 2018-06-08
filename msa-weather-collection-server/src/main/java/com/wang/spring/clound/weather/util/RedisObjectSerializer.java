package com.wang.spring.clound.weather.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.*;

/**
 * @Author: wangcheng
 * @Date: Created in 15:43 2018/6/5
 */
@Slf4j
public class RedisObjectSerializer implements RedisSerializer<Object> {

    private static final byte[] EMPTY_ARRAY = new byte[0];

    @Override
    public byte[] serialize(Object object) throws SerializationException {
        if (object == null){
            return EMPTY_ARRAY;
        }
        ObjectOutputStream obs = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            //输出到bos里
            obs = new ObjectOutputStream(bos);
            //实际上是write to obs
            obs.writeObject(object);
            byte[] byt = bos.toByteArray();
            return  byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)){
            return null;
        }
        ObjectInputStream ois = null;
        ByteArrayInputStream bis = null;
        bis = new ByteArrayInputStream(bytes);
        try {
            ois = new ObjectInputStream(bis);
            Object obj = ois.readObject();
            return obj;
        } catch (Exception e) {
            log.error("反序列化失败", e.getMessage());
        }
        return null;
    }

    private boolean isEmpty(byte[] data){
        return (data == null || data.length == 0);
    }
}
