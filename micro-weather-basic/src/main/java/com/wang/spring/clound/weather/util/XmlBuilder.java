package com.wang.spring.clound.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @Author: wangcheng
 * @Date: Created in 11:20 2018/6/7
 */
public class XmlBuilder {
    /**
     * @Author: wangcheng
     * @param clazz xmlStr
     * @Description  将XML转为指定的POJO
     * @Date: 11:22 2018/6/7
     * @return
     */
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception{
        Object xmlObject = null;
        Reader reader = null;
        //创建jaxb上下文对象
        JAXBContext context = JAXBContext.newInstance(clazz);
        //XML转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();
        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);
        if (null != reader){
            reader.close();
        }
        return xmlObject;
    }
}
