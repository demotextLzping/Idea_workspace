package com.lzp.util;

import com.lzp.pojo.Users;

import java.util.List;

public class Page {
    //一共有多少数据
    private Integer dataCount;
    //每页显示多少数据
    private Integer showData;
    //一共多少页
    private Integer pageCount;
    //当前页面是第几页
    private Integer pageIndex;
    //当前页面显示的集合信息
    private List<Users> list;

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public Integer getShowData() {
        return showData;
    }

    public void setShowData(Integer showData) {
        this.showData = showData;
    }

    public Integer getPageCount() {
        return this.dataCount % this.showData == 0 ? this.dataCount / this.showData : this.dataCount / this.showData + 1;
    }

//    public void setPageCount(Integer pageCount) {
//        this.pageCount = pageCount;
//    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<Users> getList() {
        return list;
    }

    public void setList(List<Users> list) {
        this.list = list;
    }
}
