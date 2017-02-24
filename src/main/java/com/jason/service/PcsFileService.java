package com.jason.service;

import com.jason.model.communication.HandleResult;

import java.io.File;

/**
 * Created by jason on 2017/2/20.
 */
public interface PcsFileService {
    /**
     * 上传文件
     * @param path pcs路径
     * @param file 上传的文件
     * @param ondup overwrite 覆盖同名,newcopy 生成文件副本并进行重命名，命名规则为“文件名_日期.后缀
     * @return
     */
    HandleResult uploadFile(String path,File file,String ondup);

    /**
     * 创建目录
     * @param path pcs路径
     * @return
     */
    HandleResult createDir(String path);

    /**
     * 获取单个文件或目录的元信息。
     * @param path pcs路径
     * @return
     */
    HandleResult getFsInfo(String path);

    /**
     * 批量获取文件/目录的元信息
     * @param param JSON字符串。{"list":[{"path":"\/apps\/album\/a\/b\/c"},{"path":"\/apps\/album\/a\/b\/d"}]}
     * @return
     */
    HandleResult getFsInfos(String param);

    /**
     *获取目录下的文件列表
     * @param path pcs路径
     * @param by 排序字段，缺省根据文件类型排序：time（修改时间）,name（文件名）,size（大小，注意目录无大小）

     * @param order “asc”或“desc”，缺省采用降序排序。
     * @param limit 返回条目控制，参数格式为：n1-n2。
     * @return
     */
    HandleResult getDirFiles(String path,String by,String order,String limit);

    /**
     * 移动单个文件/目录
     * @param from 源文件地址（包括文件名）。
     * @param to 目标文件地址（包括文件名）。
     * @return
     */
    HandleResult moveFs(String from,String to);

    /**
     * 删除单个文件/目录
     * @param path pcs路径
     * @return
     */
    HandleResult delFs(String path);

    /**
     * 批量删除文件/目录
     * @param param 需要删除的文件或者目录路径。如：{"list":[{"path":"\/apps\/album\/a\/b\/c"},{"path":"\/apps\/album\/a\/b\/d"}]}
     * @return
     */
    HandleResult delFsList(String param);

    /**
     * 按文件名搜索文件（不支持查找目录）。
     * @param path 需要检索的目录。
     * @param wd 关键词。
     * @param re 是否递归。
     * @return
     */
    HandleResult searchFile(String path,String wd,String re);

    /**
     * 获取缩略图
     * @param path
     * @param quality
     * @param height
     * @param width
     * @return
     */
    HandleResult getThumbnail(String path,int quality,int height,int width);

    HandleResult downloadFile(String path);
}
