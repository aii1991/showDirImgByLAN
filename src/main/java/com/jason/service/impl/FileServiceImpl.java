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
    public HandleResult insertFile(String name,String path,long size) {
        int status = Status.SUCCESS;
        File file = null;
        String errorMsg = "";
        try {
            file = createFile(name,path,size);
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

    public HandleResult modifyFile(String name, String path, long size) {
        return null;
    }

    public HandleResult findFiles() {
        try {
        }catch (Exception e){

        }
        return null;
    }



    /**
     * 根据给定参数创建file对象
     * @param name
     * @param path
     * @param size
     * @return
     */
    private File createFile(String name,String path,long size){
        long id = (name + path).hashCode();
        File file = new File();
        file.setId(id);
        file.setName(name);
        file.setSize(size);
        file.setCreateTime(System.currentTimeMillis());
        file.setUpdateTime(System.currentTimeMillis());
        return file;
    }
}
