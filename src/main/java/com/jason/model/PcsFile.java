package com.jason.model;

/**
 * Created by jason on 2017/2/20.
 */
public class PcsFile extends PcsErrRsp{
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

    @Override
    public String toString() {
        return "PcsFile{" +
                "fs_id=" + fs_id +
                ", path='" + path + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                ", block_list='" + block_list + '\'' +
                ", size=" + size +
                ", isdir=" + isdir +
                ", ifhassubdir=" + ifhassubdir +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PcsFile pcsFile = (PcsFile) o;

        if (fs_id != pcsFile.fs_id) return false;
        if (ctime != pcsFile.ctime) return false;
        if (mtime != pcsFile.mtime) return false;
        if (size != pcsFile.size) return false;
        if (isdir != pcsFile.isdir) return false;
        if (ifhassubdir != pcsFile.ifhassubdir) return false;
        if (path != null ? !path.equals(pcsFile.path) : pcsFile.path != null) return false;
        return !(block_list != null ? !block_list.equals(pcsFile.block_list) : pcsFile.block_list != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (fs_id ^ (fs_id >>> 32));
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (int) (ctime ^ (ctime >>> 32));
        result = 31 * result + (int) (mtime ^ (mtime >>> 32));
        result = 31 * result + (block_list != null ? block_list.hashCode() : 0);
        result = 31 * result + (int) (size ^ (size >>> 32));
        result = 31 * result + isdir;
        result = 31 * result + ifhassubdir;
        return result;
    }
}
