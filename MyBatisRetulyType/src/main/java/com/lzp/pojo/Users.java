package com.lzp.pojo;

import java.util.Date;
import java.util.List;

public class Users {
    private int uid;
    private String uname;
    private String sex;
    private Date birthday;
    private String address;
    private List<Orders> orders;  //用户和订单是一对多的关联关系

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Users() {
    }

    public Users(int uid, String uname, String sex, Date birthday, String address, List<Orders> orders) {
        this.uid = uid;
        this.uname = uname;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.orders = orders;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}