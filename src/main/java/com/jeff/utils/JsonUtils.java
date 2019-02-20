package com.jeff.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description: json工具类
 * @author: Jeff
 * @date: 2019年02月20日 22:49:08
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * @description: 将对象转换成json字符串
     * @param data
     * @return String
     * @author: Jeff
     * @date: 2019年02月20日 22:46:39
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @description: 将json结果集转化为对象
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return T
     * @author: Jeff
     * @date: 2019年02月20日 22:47:08
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @description: 将json数据转换成pojo对象list
     * @param jsonData
     * @param beanType
     * @return List<T>
     * @author: Jeff
     * @date: 2019年02月20日 22:47:55
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
