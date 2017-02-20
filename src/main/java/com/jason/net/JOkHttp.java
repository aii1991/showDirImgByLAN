package com.jason.net;

import com.jason.net.interceptor.LoggingInterceptor;
import com.jason.util.GsonUtil;
import com.jason.util.PropertiesUtil;
import okhttp3.*;
import java.io.File;
import java.io.IOException;
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
    private static final MediaType MEDIA_TYPE = MediaType.parse("*/*");

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
    public <T> T get(String url,Map<String,String> param,Class<T> clazz){
        StringBuilder queryString = new StringBuilder();
        if(param != null){
            int i = 1;
            for (Map.Entry<String,String> entry : param.entrySet()){
                if(entry.getValue() != null){
                    queryString.append(entry.getKey());
                    queryString.append("=");
                    queryString.append(entry.getValue());
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
            return GsonUtil.getInstance().fromJson(response.body().charStream(),clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T get(String url,Class<T> clazz){
        return get(url,null,clazz);
    }

    /**
     * post 提交请求
     * @param url
     * @param param
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T post(String url,Map<String,String> param,Class<T> clazz){
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if(param != null){
            for (Map.Entry<String,String> entry : param.entrySet()){
                if(entry.getValue() != null){
                    formBodyBuilder.add(entry.getKey(),entry.getValue());
                }
            }
        }
        RequestBody requestBody = formBodyBuilder.build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            Response response = client.newCall(request).execute();
            return GsonUtil.getInstance().fromJson(response.body().charStream(),clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T post(String url,Class<T> clazz){
        return post(url,clazz);
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
    public <T> T postFile(String url,File file,Map<String,String> param,Class<T> clazz){
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        if(param != null){
            for (Map.Entry<String,String> entry : param.entrySet()){
                if(entry.getValue() != null){
                    builder.addFormDataPart(entry.getKey(),entry.getValue());
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

}
