package com.lzp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzp.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author: LZPing
 * @date: 2022-11-28 19:33
 * @Description
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
