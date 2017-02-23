package com.jason.util;

/**
 * Created by jason on 2017/2/23.
 */
public class PagingUtil {
    private static final int PAGE_SIZE = Integer.parseInt(PropertiesUtil.newInstance().getProperty("page_size"));

    public static String getLimit(int page){
        int offset = page * PAGE_SIZE;
        int ending = offset + PAGE_SIZE;
        return offset+"-"+ending;
    }
}
