package com.team4.ailearneye;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

    private static final Gson gson = new GsonBuilder()
            .setLongSerializationPolicy(LongSerializationPolicy.STRING)
            .create();
    private static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static String toJsonPretty(Object object) {
        return gsonPretty.toJson(object);
    }

}
