package com.lzp.pojo;

import java.util.List;

public class Dept {

    private Integer deptno;

    private String dname;

    private String loc;
    private List<Emp> Emps;

    public List<Emp> getEmps() {
        return Emps;
    }

    public void setEmps(List<Emp> emps) {
        Emps = emps;
    }

    public Dept(Integer deptno, String dname, String loc, List<Emp> emps) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        Emps = emps;
    }

    public Dept() {
    }

    public Integer getDeptno() {
        return deptno;
    }


    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }


    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }


    public String getLoc() {
        return loc;
    }


    public void setLoc(String loc) {
        this.loc = loc;
    }
}