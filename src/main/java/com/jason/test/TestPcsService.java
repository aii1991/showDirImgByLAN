package com.jason.test;

import com.jason.service.PcsFileService;
import com.jason.service.impl.PcsFileServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jason on 2017/2/20.
 */
public class TestPcsService{

    @Test
    public void testGetDirFiles(){
        PcsFileService pcsFileService = new PcsFileServiceImpl();
        pcsFileService.getDirFiles("%2Ffilm","time","asc","0-10");
    }

}
