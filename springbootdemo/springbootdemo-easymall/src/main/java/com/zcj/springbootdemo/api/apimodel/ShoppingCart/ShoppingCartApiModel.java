package com.zcj.springbootdemo.api.apimodel.ShoppingCart;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ShoppingCartApiModel {
    private int BBSID;
    private String BBSName;

    public int getBBSID() {
        return BBSID;
    }

    public void setBBSID(int BBSID) {
        this.BBSID = BBSID;
    }

    public String getBBSName() {
        return BBSName;
    }

    public void setBBSName(String BBSName) {
        this.BBSName = BBSName;
    }
}
