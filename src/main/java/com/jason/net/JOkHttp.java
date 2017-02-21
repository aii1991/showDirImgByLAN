package com.jason.net;

import com.jason.net.interceptor.LoggingInterceptor;
import com.jason.util.GsonUtil;
import com.jason.util.PropertiesUtil;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jason on 2017/2/20.
 */
public class JOkHttp {
    private JOkHttp(){
        initClient();
    }
    private static JOkHttp jOkHttp;
    private static OkHttpClient client;
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/octet-stream");
    public static final String ENCODEING = "UTF-8";

    public static JOkHttp newInstance(){
        if(jOkHttp == null){
            jOkHttp = new JOkHttp();
        }
        return jOkHttp;
    }

    private void initClient(){
        long connectTime = Long.parseLong(PropertiesUtil.newInstance().getProperty("connect_timeout"));
        long readTimeout = Long.parseLong(PropertiesUtil.newInstance().getProperty("read_timeout"));
        long writeTimeout = Long.parseLong(PropertiesUtil.newInstance().getProperty("write_timeout"));

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(connectTime, TimeUnit.MILLISECONDS);
        builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        builder.writeTimeout(writeTimeout, TimeUnit.MILLISECONDS);
        builder.addNetworkInterceptor(new LoggingInterceptor());
        client = builder.build();
    }

    /**
     * get请求获取数据(同步请求)
     * @param url
     * @param param
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String url,Map<String,String> param,Class<T> clazz,Type typeOf){
        StringBuilder queryString = new StringBuilder("?");
        if(param != null){
            int i = 1;
            for (Map.Entry<String,String> entry : param.entrySet()){
                if(entry.getValue() != null){
                    queryString.append(entry.getKey());
                    queryString.append("=");
                    try {
                        queryString.append(URLEncoder.encode(entry.getValue(),ENCODEING));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    if (i != param.size()){
                        queryString.append("&");
                    }
                }
                i++;
            }
        }
        url += queryString;
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            if (typeOf != null){
                return GsonUtil.getInstance().fromJson(response.body().charStream(),typeOf);
            }
            return GsonUtil.getInstance().fromJson(response.body().charStream(),clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T get(String url,Map<String,String> param,Class<T> clazz){
        return get(url,param,clazz,null);
    }

    public <T> T get(String url,Map<String,String> param,Type typeOf){
        return get(url,param,null,typeOf);
    }

    public <T> T get(String url,Type typeOf){
        return get(url,null,null,typeOf);
    }

    public <T> T get(String url,Class<T> clazz){
        return get(url,null,clazz,null);
    }

    /**
     * post 提交请求
     * @param url
     * @param param
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T post(String url,Map<String,String> param,Class<T> clazz,Type typeOf){
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if(param != null){
            for (Map.Entry<String,String> entry : param.entrySet()){
                if(entry.getValue() != null){
                    formBodyBuilder.addEncoded(entry.getKey(),entry.getValue());
                }
            }
        }
        RequestBody requestBody = formBodyBuilder.build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            Response response = client.newCall(request).execute();
            if (typeOf != null){
                return GsonUtil.getInstance().fromJson(response.body().charStream(),typeOf);
            }
            return GsonUtil.getInstance().fromJson(response.body().charStream(),clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T post(String url,Map<String,String> param,Class<T> clazz){
        return post(url,param,null,clazz);
    }

    public <T> T post(String url,Map<String,String> param,Type typeOf){
        return post(url,param,null,typeOf);
    }

    public <T> T post(String url,Type typeOf){
        return post(url,null,null,typeOf);
    }

    public <T> T post(String url,Class<T> clazz){
        return post(url,null,clazz,null);
    }

    /**
     * 上传单个文件
     * @param url
     * @param file
     * @param param
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T postFileByMultipart(String url, File file, Map<String, String> param, Class<T> clazz){
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        if(param != null){
            for (Map.Entry<String,String> entry : param.entrySet()){
                if(entry.getValue() != null){
                    try {
                        builder.addFormDataPart(entry.getKey(),URLEncoder.encode(entry.getValue(),ENCODEING));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        builder.addFormDataPart("file", file.getName(), RequestBody.create(MEDIA_TYPE,file));
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }else {
                return GsonUtil.getInstance().fromJson(response.body().charStream(),clazz);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T postFile(String url, File file, Class<T> clazz){
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MEDIA_TYPE,file))
                .build();
        try {
            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }else {
                return GsonUtil.getInstance().fromJson(response.body().charStream(),clazz);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
