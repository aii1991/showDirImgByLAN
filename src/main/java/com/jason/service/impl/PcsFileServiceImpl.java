package com.jason.service.impl;

import com.jason.constants.Status;
import com.jason.model.PcsFile;
import com.jason.model.communication.HandleResult;
import com.jason.net.JOkHttp;
import com.jason.service.PcsFileService;
import com.jason.util.PropertiesUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jason on 2017/2/20.
 */
public class PcsFileServiceImpl implements PcsFileService{
    private static final String TOKEN = PropertiesUtil.newInstance().getProperty("pcb_token");
    private static final String BASE_URL = PropertiesUtil.newInstance().getProperty("pcb_base_url");

    public HandleResult uploadFile(String path, File file, String ondup) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> param = createParamMap("upload");
        param.put("path",path);
        param.put("ondup",ondup);
        PcsFile pcsFile = JOkHttp.newInstance().postFile(BASE_URL,file,param, PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult createDir(String path) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> param = createParamMap("mkdir");
        param.put("method","mkdir");
        param.put("path",path);
        PcsFile pcsFile = JOkHttp.newInstance().post(BASE_URL,param,PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult getFsInfo(String path) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> param = createParamMap("meta");
        param.put("path",path);
        PcsFile pcsFile = JOkHttp.newInstance().get(BASE_URL, param, PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult getFsInfos(String param) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> paramMap = createParamMap("meta");
        paramMap.put("param", param);
        PcsFile pcsFile = JOkHttp.newInstance().get(BASE_URL, paramMap, PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult getDirFiles(String path, String by, String order, String limit) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> param = createParamMap("list");
        param.put("path",path);
        param.put("by",by);
        param.put("order",order);
        param.put("limit",limit);
        PcsFile pcsFile = JOkHttp.newInstance().get(BASE_URL, param, PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult moveFs(String from, String to) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> param = createParamMap("move");
        param.put("from",to);
        param.put("to",to);
        PcsFile pcsFile = JOkHttp.newInstance().post(BASE_URL,param,PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult delFs(String path) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> param = createParamMap("delete");
        param.put("path",path);
        PcsFile pcsFile = JOkHttp.newInstance().post(BASE_URL,param,PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult delFsList(String param) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> paramMap = createParamMap("delete");
        paramMap.put("param", param);
        PcsFile pcsFile = JOkHttp.newInstance().post(BASE_URL,paramMap,PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult searchFile(String path, String wd, String re) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> paramMap = createParamMap("search");
        paramMap.put("path", path);
        paramMap.put("wd", wd);
        paramMap.put("re", re);
        PcsFile pcsFile = JOkHttp.newInstance().get(BASE_URL, paramMap, PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult getThumbnail(String path, int quality, int height, int width) {
        return null;
    }

    private Map<String,String> createParamMap(String method){
        Map<String,String> param = new HashMap<String, String>();
        param.put("method",method);
        param.put("access_token",TOKEN);
        return param;
    }
}
