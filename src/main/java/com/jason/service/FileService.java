package com.jason.service;

import com.jason.model.communication.HandleResult;

/**
 * Created by jason on 2017/2/17.
 */
public interface FileService {
    HandleResult insertFile(String name,String path,long size);
    HandleResult findFileById(long id);
    HandleResult modifyFile(String name,String path,long size);
    HandleResult findFiles();
}
