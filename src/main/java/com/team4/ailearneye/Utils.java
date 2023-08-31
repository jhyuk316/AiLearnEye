package com.team4.ailearneye;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

    public static final Gson gson = new Gson();
    private static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();

    // public static String toJson(Object object) {
    //     return gson.toJson(object);
    // }
    //
    // public static String toJsonPretty(Object object) {
    //     return gsonPretty.toJson(object);
    // }

}
