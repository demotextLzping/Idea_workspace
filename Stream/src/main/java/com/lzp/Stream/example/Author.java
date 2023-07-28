package com.lzp.Stream.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: LZPing
 * @date: 2023-01-08 14:00
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Author implements Serializable {
    private Long id; //id
    private String name;  //姓名
    private Integer age;  //年龄
    private String intro; // 简介
    private List<Book> books;//作品
}
