package com.jason.service.impl;

import com.jason.constants.Status;
import com.jason.dao.FileMapper;
import com.jason.model.File;
import com.jason.model.communication.HandleResult;
import com.jason.service.FileService;

/**
 * Created by jsaon on 2017/2/17.
 */
public class FileServiceImpl extends BaseServiceImpl<FileMapper> implements FileService {
    public HandleResult insertFile(File file) {
        int status = Status.SUCCESS;
        String errorMsg = "";
        try {
            int sqlResult = mapper.insertSelective(file);
            if (sqlResult == 0){
                status = Status.ERROR;
            }
        }catch (Exception e){
            e.printStackTrace();
            errorMsg = "服务器内部错误";
            status = Status.ERROR;
        }

        return new HandleResult(status,file,errorMsg);
    }

    public HandleResult findFileById(long id) {
        File file = null;
        int status = Status.SUCCESS;
        String errorMsg = "";
        try {
            file = mapper.selectByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            errorMsg = "服务器内部错误";
            status = Status.ERROR;
        }
        return new HandleResult(status,file,errorMsg);
    }

    public HandleResult modifyFile(File file) {
        int status = Status.SUCCESS;
        String errorMsg = "";
        try {
            int sqlExcStatus = mapper.updateByPrimaryKeySelective(file);
            if(sqlExcStatus == 0){
                status = Status.ERROR;
                errorMsg = "操作失败";
            }
        }catch (Exception e){
            errorMsg = "服务器内部错误";
            status = Status.ERROR;
        }
        return new HandleResult(status,file,errorMsg);
    }

    public HandleResult findFiles(File file) {
        try {

        }catch (Exception e){

        }
        return null;
    }
}
