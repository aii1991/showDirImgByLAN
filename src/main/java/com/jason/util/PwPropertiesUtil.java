package com.jason.util;

/**
 * Created by songlive on 2016/8/15.
 */
public class PwPropertiesUtil {
    public final static String CONFIG_FILE_PATH = "config/config.properties";
    private PwPropertiesUtil(){
        propertiesUtil = new PropertiesUtil(CONFIG_FILE_PATH);
    }
    public static PwPropertiesUtil instance;
    private PropertiesUtil propertiesUtil;

    public static PwPropertiesUtil getInstance(){
        if (instance == null){
            instance = new PwPropertiesUtil();
        }
        return instance;
    }

    public PropertiesUtil getPropertiesUtil(){
        return propertiesUtil;
    }

}
