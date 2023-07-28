package com.lzp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 * @author: LZPing
 * @date: 2022-11-28 19:26
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("") 如果实体类名和数据库中的名称不一样使用改注解
public class Dept implements Serializable {

//    @TableField(exist = false)  如果实体中的字段是数据库中没有的或报错异常 使用该注解之后不会报错
//    private  String aaa;

    //    @TableField("") 如果实体类中的字段和数据中不一样 使用改注解
    private Integer deptno;
    private String dname;
    private String loc;
}
