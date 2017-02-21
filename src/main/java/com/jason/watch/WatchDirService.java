package com.jason.watch;

import com.jason.util.PropertiesUtil;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WatchDirService {
    private WatchService watchService;
    private boolean notDone = true;

    public WatchDirService(String dirPath){
        init(dirPath);
    }

    private void init(String dirPath) {
        Path path = Paths.get(dirPath);
        try {
            watchService = FileSystems.getDefault().newWatchService();
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_MODIFY,StandardWatchEventKinds.ENTRY_DELETE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.print("watch...");
        while (notDone){
            try {
                WatchKey watchKey = watchService.poll(Long.parseLong(PropertiesUtil.newInstance().getProperty("poll_time_out")), TimeUnit.MILLISECONDS);
                if(watchKey != null){
                    List<WatchEvent<?>> events = watchKey.pollEvents();
                    for (WatchEvent event : events){
                        WatchEvent.Kind<?> kind = event.kind();
                        if (kind == StandardWatchEventKinds.OVERFLOW){
                            continue;
                        }
                        WatchEvent<Path> ev = event;
                        Path path = ev.context();
                        if(kind == StandardWatchEventKinds.ENTRY_CREATE){
                            System.out.println("create " + path.getFileName());
                        }else if(kind == StandardWatchEventKinds.ENTRY_MODIFY){
                            System.out.println("modify " + path.getFileName());
                        }else if(kind == StandardWatchEventKinds.ENTRY_DELETE){
                            System.out.println("delete " + path.getFileName());
                        }
                    }
                    if(!watchKey.reset()){
                        System.out.println("exit watch server");
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}