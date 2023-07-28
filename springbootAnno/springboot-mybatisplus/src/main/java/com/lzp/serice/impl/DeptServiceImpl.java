package com.lzp.serice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzp.mapper.DeptMapper;
import com.lzp.pojo.Dept;
import com.lzp.serice.DeptService;
import org.springframework.stereotype.Service;

/**
 * @author: LZPing
 * @date: 2022-11-28 19:34
 * @Description
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
}
