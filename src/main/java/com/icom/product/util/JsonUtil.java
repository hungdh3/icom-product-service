package com.icom.product.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtil {
    public static String objectToString(Object o) {
        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object stringToObject(String str, Class c) {
        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        try {
            return objectMapper.readValue(str, c);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
