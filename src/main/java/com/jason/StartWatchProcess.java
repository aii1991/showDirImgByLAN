package com.jason;

import com.jason.watch.WatchDirService;

/**
 * Created by jason on 2017/2/21.
 */
public class StartWatchProcess {
    private final static String DIR_PATH = "D:\\test-watch";

    public static void main(String[] args) {
        WatchDirService watchDirService = new WatchDirService(DIR_PATH);
        watchDirService.start();
    }
}
