package com.jason.service.impl;

import com.jason.constants.Status;
import com.jason.model.PcsFile;
import com.jason.model.PcsFileList;
import com.jason.model.communication.HandleResult;
import com.jason.net.JOkHttp;
import com.jason.service.PcsFileService;
import com.jason.util.PropertiesUtil;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jason on 2017/2/20.
 */
@Service(value = "pcsFileServiceImpl")
public class PcsFileServiceImpl implements PcsFileService{
    private static final String TOKEN = PropertiesUtil.newInstance().getProperty("pcb_token");
    private static final String BASE_URL = PropertiesUtil.newInstance().getProperty("pcb_base_url");

    public HandleResult uploadFile(String path, File file, String ondup) {
        int status = Status.SUCCESS;
        String errMsg = "";
        StringBuilder url = new StringBuilder(BASE_URL);
        try {
            url.append("?");
            url.append("method=upload");
            url.append("&");
            url.append("access_token=");
            url.append(PropertiesUtil.newInstance().getProperty("pcb_token"));
            url.append("&");
            url.append("path=");url.append(URLEncoder.encode(path+"/"+file.getName(),JOkHttp.ENCODEING));
            if(ondup != null){
                url.append("&");
                url.append("ondup=");
                url.append(ondup);
            }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
//        PcsFile pcsFile = JOkHttp.newInstance().postFileByMultipart(url.toString(),file,null,PcsFile.class);
        PcsFile pcsFile = JOkHttp.newInstance().postFileByMultipart(url.toString(), file, null, PcsFile.class);
        if(pcsFile == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }else {
            if(pcsFile.getError_code() != 0){
                status = pcsFile.getError_code();
                errMsg = pcsFile.getError_msg();
            }
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
        }else {
            if(pcsFile.getError_code() != 0){
                status = pcsFile.getError_code();
                errMsg = pcsFile.getError_msg();
            }
        }
        return new HandleResult(status,pcsFile,errMsg);
    }

    public HandleResult getFsInfo(String path) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> param = createParamMap("meta");
        param.put("path",path);
        PcsFileList pcsFileList = JOkHttp.newInstance().get(BASE_URL, param, PcsFileList.class);
        if(pcsFileList == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }else {
            if(pcsFileList.getError_code() != 0){
                status = pcsFileList.getError_code();
                errMsg = pcsFileList.getError_msg();
            }
        }
        return new HandleResult(status,pcsFileList,errMsg);
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
        }else {
            if(pcsFile.getError_code() != 0){
                status = pcsFile.getError_code();
                errMsg = pcsFile.getError_msg();
            }
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
        PcsFileList pcsFileList = JOkHttp.newInstance().get(BASE_URL, param, PcsFileList.class);
        if(pcsFileList == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }else {
            if(pcsFileList.getError_code() != 0){
                status = pcsFileList.getError_code();
                errMsg = pcsFileList.getError_msg();
            }
        }
        return new HandleResult(status,pcsFileList,errMsg);
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
        }else {
            if(pcsFile.getError_code() != 0){
                status = pcsFile.getError_code();
                errMsg = pcsFile.getError_msg();
            }
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
        }else {
            if(pcsFile.getError_code() != 0){
                status = pcsFile.getError_code();
                errMsg = pcsFile.getError_msg();
            }
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
        }else {
            if(pcsFile.getError_code() != 0){
                status = pcsFile.getError_code();
                errMsg = pcsFile.getError_msg();
            }
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
        PcsFileList pcsFileList = JOkHttp.newInstance().get(BASE_URL, paramMap, PcsFileList.class);
        if(pcsFileList == null){
            status = Status.ERROR;
            errMsg = "服务器内部错误";
        }else {
            if(pcsFileList.getError_code() != 0){
                status = pcsFileList.getError_code();
                errMsg = pcsFileList.getError_msg();
            }
        }
        return new HandleResult(status,pcsFileList,errMsg);
    }

    public HandleResult getThumbnail(String path, int quality, int height, int width) {
        return null;
    }

    public HandleResult downloadFile(String path) {
        int status = Status.SUCCESS;
        String errMsg = "";
        Map<String,String> paramMap = createParamMap("download");
        Response response = null;
        paramMap.put("path", path);
        try {
            response = JOkHttp.newInstance().execGetReq(BASE_URL, paramMap);
        } catch (IOException e) {
            status = Status.ERROR;
            errMsg = "download error";
            e.printStackTrace();
        }
        return new HandleResult(status,response,errMsg);
    }

    private Map<String,String> createParamMap(String method){
        Map<String,String> param = new HashMap<String, String>();
        param.put("method",method);
        param.put("access_token",TOKEN);
        return param;
    }
}
