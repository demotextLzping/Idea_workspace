package com.lzp.mapper;

import com.lzp.pojo.Users;
import com.lzp.util.Page;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UsersMapper {
//    根据用户编号，查询该用户下，所有的订单，订单详情，商品信息
    Users selectAll(int uid) throws Exception;

    //用于分页，获得一共多少数据
    int selectCount() throws Exception;

    //获取当前页显示的信息
    List<Users> selectUserByPage(Page page) throws  Exception;
    List<Users> autoUserSelectByPage(RowBounds rb) throws  Exception;
}