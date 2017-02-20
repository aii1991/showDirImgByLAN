package com.jason.service;

import com.jason.model.File;
import com.jason.model.communication.HandleResult;

/**
 * Created by jason on 2017/2/17.
 */
public interface FileService {
    HandleResult insertFile(File file);
    HandleResult findFileById(long id);
    HandleResult modifyFile(File file);
    HandleResult findFiles(File file);
}
