package com.lzp.mapper;

import com.lzp.pojo.Orderdetail;

public interface OrderdetailMapper {
    Orderdetail selectLazyLoadByOdid(int odid) throws Exception;

}