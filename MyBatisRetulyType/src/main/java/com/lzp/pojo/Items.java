package com.lzp.pojo;

import java.io.Serializable;

public class Items implements Serializable {

    private Integer iid;


    private String name;


    private String detail;


    private Double price;

    public Integer getIid() {
        return iid;
    }

    public Items(Integer iid, String name, String detail, Double price) {
        this.iid = iid;
        this.name = name;
        this.detail = detail;
        this.price = price;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getDetail() {
        return detail;
    }


    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }


    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }
}