package com.team4.ailearneye;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

    public static final Gson gson = new Gson();
    private static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        String json = "";
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.info(e.getMessage(), e);
        }
        return json;
    }
    //
    // public static String toJsonPretty(Object object) {
    //     return gsonPretty.toJson(object);
    // }

}
