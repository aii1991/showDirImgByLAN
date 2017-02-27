package com.jason.util;

/**
 * Created by jason on 2017/2/25.
 */
public class FileUtil {
    /**
     * 通过文件路径获取文件名
     * @param path
     * @return
     */
    public static String getFileNameByPath(String path){
        String fileName = path.substring(path.lastIndexOf("/")+1);
        return fileName;
    }

    /**
     * 通过文件名判断是否为图片格式
     * @param fileName
     * @return
     */
    public static boolean isImg(String fileName){
        String[] strings = fileName.split("\\.");
        if(strings.length > 1){
            String ext = strings[1];
            if(ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("gif")){
                return true;
            }
        }
        return false;
    }
}
