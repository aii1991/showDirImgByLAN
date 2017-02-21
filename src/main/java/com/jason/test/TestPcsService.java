package com.jason.test;

import com.jason.constants.Status;
import com.jason.model.PcsFile;
import com.jason.model.PcsFileList;
import com.jason.model.communication.HandleResult;
import com.jason.service.PcsFileService;
import com.jason.service.impl.PcsFileServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;

/**
 * Created by jason on 2017/2/20.
 */
@RunWith(Junit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:config/spring-mybatis.xml"})
public class TestPcsService{
    PcsFileService pcsFileService;

    @Before
    public void initPcsFileService(){
        pcsFileService = new PcsFileServiceImpl();
    }

    @Test
    public void testGetFsInfo(){
        HandleResult<PcsFileList> handleResult = pcsFileService.getFsInfo("/apps/%252Fzhiyun/a.txt");
        System.out.println("result=>"+handleResult.getResult().toString());
    }

    @Test
    public void testGetDirFiles(){
        HandleResult<PcsFileList> handleResult = pcsFileService.getDirFiles("/apps/%252Fzhiyun","time","asc",null);
        System.out.println("result=>"+handleResult.getResult().toString());
    }

    @Test
    public void testUploadFile(){
        HandleResult<PcsFile> handleResult = pcsFileService.uploadFile("/apps/%252Fzhiyun",new File("D:\\zjh","test111.txt"),"overwrite");
        if(handleResult.getStatus() == Status.SUCCESS){
            System.out.println("result=>"+handleResult.getResult().toString());
        }
    }

    @Test
    public void deleteFs(){
        HandleResult<PcsFile> handleResult = pcsFileService.delFs("/apps/%252Fzhiyun/test111.txt");
        System.out.println("result=>"+handleResult.getResult().toString());
    }

    @Test
    public void searchFile(){
        HandleResult<PcsFileList> handleResult = pcsFileService.searchFile("/apps/%252Fzhiyun","a","0");
        System.out.println("result=>"+handleResult.getResult().toString());
    }


}
