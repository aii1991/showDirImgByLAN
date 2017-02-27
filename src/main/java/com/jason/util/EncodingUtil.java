package com.jason.util;

import com.jason.constants.AppConfig;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by jason on 2017/2/24.
 */
public class EncodingUtil {
    public static String urlEncoding(String str){
        try {
            return URLEncoder.encode(str, AppConfig.ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
