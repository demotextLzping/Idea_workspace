package com.lzp.pojo;

public class User {
    private Integer uid;
    private String uname;
    private Integer uage;
    private String usex;

    public User() {
    }

    public User(Integer uid, String uname, Integer uage, String usex) {
        this.uid = uid;
        this.uname = uname;
        this.uage = uage;
        this.usex = usex;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uage=" + uage +
                ", usex='" + usex + '\'' +
                '}';
    }
}
