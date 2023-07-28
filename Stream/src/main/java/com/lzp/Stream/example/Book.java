package com.lzp.Stream.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: LZPing
 * @date: 2023-01-08 14:02
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book implements Serializable {
    private Long id; //id
    private String name; //姓名
    private String category; //分类
    private Integer score; //评分
    private String intro; //简介

}
