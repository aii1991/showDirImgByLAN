package com.jason.dao;

import com.jason.model.File;

public interface FileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}