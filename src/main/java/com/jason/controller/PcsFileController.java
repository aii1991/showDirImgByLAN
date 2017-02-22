package com.jason.controller;

import com.jason.service.PcsFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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


    @RequestMapping(value = "/listFile",method = RequestMethod.GET)
    public ModelAndView listFile(@RequestParam(name = "path",defaultValue = "/")String path){
        ModelAndView modelAndView = new ModelAndView("list_file");
        return modelAndView;
    }
}
