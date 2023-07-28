package com.lzp.test;

import com.lzp.mapper.OrderdetailMapper;
import com.lzp.mapper.UsersMapper;
import com.lzp.pojo.Orderdetail;
import com.lzp.pojo.Users;
import com.lzp.util.Page;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        InputStream stream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(stream);
    }

    @Test
    public void test() throws Exception {
        SqlSession session = factory.openSession();
        OrderdetailMapper mapper = session.getMapper(OrderdetailMapper.class);
        Orderdetail orderdetail = mapper.selectLazyLoadByOdid(6);
        session.close();
        System.out.println(orderdetail.getOrderid());
        System.out.println(orderdetail.getItems().getName());
    }
}
