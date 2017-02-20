package com.jason.model;

/**
 * Created by jason on 2017/2/20.
 */
public class PcsFile {
    private long fs_id; //文件或目录在PCS的临时唯一标识ID。
    private String path; //文件或目录的绝对路径。
    private long ctime; //文件或目录的创建时间。
    private long mtime; //文件或目录的最后修改时间。
    private String block_list; //文件所有分片的md5数组JSON字符串。
    private long size; //文件大小（byte）。
    private int isdir; //是否是目录的标识符
    private int ifhassubdir; //是否含有子目录的标识符

    public long getFs_id() {
        return fs_id;
    }

    public void setFs_id(long fs_id) {
        this.fs_id = fs_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public long getMtime() {
        return mtime;
    }

    public void setMtime(long mtime) {
        this.mtime = mtime;
    }

    public String getBlock_list() {
        return block_list;
    }

    public void setBlock_list(String block_list) {
        this.block_list = block_list;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getIsdir() {
        return isdir;
    }

    public void setIsdir(int isdir) {
        this.isdir = isdir;
    }

    public int getIfhassubdir() {
        return ifhassubdir;
    }

    public void setIfhassubdir(int ifhassubdir) {
        this.ifhassubdir = ifhassubdir;
    }
}
