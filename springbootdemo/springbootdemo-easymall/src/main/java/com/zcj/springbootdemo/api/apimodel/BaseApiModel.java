package com.zcj.springbootdemo.api.apimodel;

import java.util.*;

/**
 * Created by Administrator on 2017/4/7.
 */
public class BaseApiModel {
    private int returncode;
    private String message;
    private Map<String,Object> result;

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
