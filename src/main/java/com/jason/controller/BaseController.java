package com.jason.controller;

import org.apache.log4j.Logger;

/**
 * Created by jason on 2017/2/22.
 */
public class BaseController {
    protected Logger logger;
    public BaseController(){
        logger = Logger.getLogger(this.getClass());
    }
}
