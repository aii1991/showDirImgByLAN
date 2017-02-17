package com.jason.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jason on 2017/2/17.
 */
@RequestMapping(value = "/v1",produces="application/json;charset=UTF-8")
public class BaseController {
    protected Logger logger;

    public BaseController(){
        logger = Logger.getLogger(this.getClass());
    }
}
