package com.jason.interceptor;

import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by jason on 2016/7/7.
 */
public class Utf8HttpStringMessageConverter extends StringHttpMessageConverter {
    private static final MediaType utf8 = new MediaType("text", "plain", Charset.forName("UTF-8"));

    @Override
    protected MediaType getDefaultContentType(String s) throws IOException {
        return utf8;
    }
}
