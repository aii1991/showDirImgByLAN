package com.jason.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jason on 2017/2/21.
 */
public class PcsFileList extends PcsErrRsp{
    private List<PcsFile> list;

    public List<PcsFile> getList() {
        return list;
    }

    public void setList(List<PcsFile> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PcsFileList{" +
                "list=" + list +
                "} " + super.toString();
    }
}
