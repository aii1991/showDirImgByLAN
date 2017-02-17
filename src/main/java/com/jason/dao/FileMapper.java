package com.jason.dao;

import com.jason.model.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);

    List<File> selectAllTopic(@Param("offset") int offset,@Param("limit") int limit,@Param("sort") int sort);
}