package com.lzp.mapper;

import com.lzp.pojo.Items;

public interface ItemsMapper {
    Items selectByIid(int iid) throws Exception;
    int insertInfo(Items items) throws  Exception;


}