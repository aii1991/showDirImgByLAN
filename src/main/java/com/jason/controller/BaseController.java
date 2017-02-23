package com.jason.controller;

import com.jason.util.PropertiesUtil;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jason on 2017/2/22.
 */
public class BaseController {
    protected PropertiesUtil propertiesUtil;
    protected Logger logger;
    protected ModelAndView errorView;
    public BaseController(){
        propertiesUtil = PropertiesUtil.newInstance();
        logger = Logger.getLogger(this.getClass());
        errorView = new ModelAndView("error");
        errorView.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
