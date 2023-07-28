package com.lzp.pojo;

public class Orderdetail {
    private Integer odid;

    private String orderid;

    private Integer itemid;

    private Integer itemnum;

    private Items items;//订单详情和商品是一大堆一的关系

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Orderdetail() {
    }

    public Orderdetail(Integer odid, String orderid, Integer itemid, Integer itemnum, Items items) {
        this.odid = odid;
        this.orderid = orderid;
        this.itemid = itemid;
        this.itemnum = itemnum;
        this.items = items;
    }

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemnum() {
        return itemnum;
    }

    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }
}