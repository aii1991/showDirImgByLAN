package com.jason.controller;

import com.jason.constants.Status;
import com.jason.model.PcsFileList;
import com.jason.model.communication.HandleResult;
import com.jason.service.PcsFileService;
import com.jason.util.PagingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by jason on 2017/2/21.
 */

@Controller
public class PcsFileController extends BaseController{
    @Resource
    private PcsFileService pcsFileService;
    private final String BASE_PATH = propertiesUtil.getProperty("pcb_base_path");

    @RequestMapping(value = "/listFile",method = RequestMethod.GET)
    public ModelAndView listFile(@RequestParam(name = "path",defaultValue = "")String path,@RequestParam(name = "page",defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("list_file");
        HandleResult<PcsFileList> handleResult = pcsFileService.getDirFiles(BASE_PATH + path, "time", "asc", PagingUtil.getLimit(page));
        if(handleResult.getStatus() == Status.SUCCESS){
            modelAndView.addObject(handleResult.getResult());
            return modelAndView;
        }else {
            return errorView;
        }
    }

}
