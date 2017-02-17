package com.jason.model.communication;

/**
 * Created by jason on 2016/7/5.
 */
public class HandleResult<T> {
    private int status;
    private T result;
    private String errorMsg;

    public HandleResult(int status) {
        this.status = status;
    }

    public HandleResult(int status, String errorMsg) {
        this.status = status;
        this.errorMsg = errorMsg;
    }

    public HandleResult(int status, T result) {
        this.status = status;
        this.result = result;
    }

    public HandleResult(int status, T result, String errorMsg) {
        this.status = status;
        this.result = result;
        this.errorMsg = errorMsg;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
