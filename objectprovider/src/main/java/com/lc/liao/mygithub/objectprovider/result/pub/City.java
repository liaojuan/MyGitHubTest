package com.lc.liao.mygithub.objectprovider.result.pub;

import java.io.Serializable;

/**
 * Created by liao on 2017/3/9.
 */

public class City implements Serializable {
    public String code;
    public String name;
    public String alphabet;
    public String adcode;
    //0:非热搜 1：热搜
    public  int hot;

    public City(String code, String name, String alphabet) {
        this.code = code;
        this.name = name;
        this.alphabet = alphabet;
    }

    public City() {
    }
}
