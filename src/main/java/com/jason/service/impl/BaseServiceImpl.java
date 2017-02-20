package com.jason.service.impl;

import com.jason.util.PropertiesUtil;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

/**
 * Created by jason on 2017/2/17.
 */
public class BaseServiceImpl<T> {
    @Resource
    protected T mapper;

    protected Logger logger;
    protected PropertiesUtil propertiesUtil;

    public BaseServiceImpl(){
        logger = Logger.getLogger(this.getClass());
        propertiesUtil = PropertiesUtil.newInstance();
    }

}
