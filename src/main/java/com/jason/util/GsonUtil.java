package com.jason.util;

import com.google.gson.Gson;

import java.io.Reader;
import java.lang.reflect.Type;

/**
 * Created by jason on 2016/7/5.
 */
public class GsonUtil {
    private Gson gson;
    private static GsonUtil instance;
    private GsonUtil(){
        gson = new Gson();
    }

    public static GsonUtil getInstance(){
        if (instance == null){
            instance = new GsonUtil();
        }
        return instance;
    }

    public String toJson(Object Obj){
        return gson.toJson(Obj);
    }

    public <T> T fromJson(String jsonData,Class<T> Clazz){
        try {
            return gson.fromJson(jsonData,Clazz);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public <T> T fromJson(Reader reader,Class<T> Clazz){
        try {
            return gson.fromJson(reader,Clazz);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public <T> T fromJson(String jsonData,Type typeOf){
        try {
            return gson.fromJson(jsonData,typeOf);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
