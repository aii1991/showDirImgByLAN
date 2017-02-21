package com.jason.model;

/**
 * Created by jason on 2017/2/21.
 */
public class PcsErrRsp {
    private int error_code;
    private String error_msg;
    private long request_id;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(long request_id) {
        this.request_id = request_id;
    }

    @Override
    public String toString() {
        return "PcsErrRsp{" +
                "error_code=" + error_code +
                ", error_msg='" + error_msg + '\'' +
                ", request_id=" + request_id +
                '}';
    }
}
