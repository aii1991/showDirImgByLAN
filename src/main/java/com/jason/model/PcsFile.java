package com.jason.model;

/**
 * Created by jason on 2017/2/20.
 */
public class PcsFile {
    private long fs_id; //�ļ���Ŀ¼��PCS����ʱΨһ��ʶID��
    private String path; //�ļ���Ŀ¼�ľ���·����
    private long ctime; //�ļ���Ŀ¼�Ĵ���ʱ�䡣
    private long mtime; //�ļ���Ŀ¼������޸�ʱ�䡣
    private String block_list; //�ļ����з�Ƭ��md5����JSON�ַ�����
    private long size; //�ļ���С��byte����
    private int isdir; //�Ƿ���Ŀ¼�ı�ʶ��
    private int ifhassubdir; //�Ƿ�����Ŀ¼�ı�ʶ��

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
