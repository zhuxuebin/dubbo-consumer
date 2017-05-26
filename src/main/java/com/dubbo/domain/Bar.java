package com.dubbo.domain;

import java.io.Serializable;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class Bar implements Serializable{
    private int id;
    private String barName;

    public Bar() {
    }

    public Bar(int id, String barName) {
        this.id = id;
        this.barName = barName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }
}
