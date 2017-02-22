package com.jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jason on 2017/2/17.
 */
@Controller
public class FileController extends BaseRestfulController{

    @RequestMapping(value = "/file",method = RequestMethod.GET)
    @ResponseBody
    public String insertFile(String file){
        return "success";
    }
}
