package com.lzp.model;

import com.jfinal.plugin.activerecord.Model;
import lombok.Data;

@Data
public class User extends Model<User> {
    private Integer uid;
    private String uname;
    private String upwd;
}
