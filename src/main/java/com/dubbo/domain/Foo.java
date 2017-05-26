package com.dubbo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 01368080 on 2017/4/28.
 */
public class Foo implements Serializable{
    private int id;
    private Date date;
    private String name;

    public Foo() {
    }

    public Foo(int id, Date date, String name) {
        this.id = id;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
