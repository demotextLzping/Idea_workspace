package com.lzp.test;

import com.lzp.mapper.ItemsMapper;
import com.lzp.mapper.OrderdetailMapper;
import com.lzp.pojo.Items;
import com.lzp.pojo.Orderdetail;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisCache {
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        InputStream stream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(stream);
    }

    //测试一级缓存
    @Test
    public void test() throws Exception {
        SqlSession session = factory.openSession();
        ItemsMapper mapper = session.getMapper(ItemsMapper.class);
        Items items = mapper.selectByIid(3);
        System.out.println(items.getName() + " " + items.getDetail());
        session.commit();
        Items items1 = mapper.selectByIid(3);
        System.out.println(items1.getName() + " " + items1.getDetail());
    }

    //测试二级缓存
    @Test
    public void test2() throws Exception {
        SqlSession session = factory.openSession();
        ItemsMapper mapper = session.getMapper(ItemsMapper.class);
        SqlSession session2 = factory.openSession();
        ItemsMapper mapper2 = session2.getMapper(ItemsMapper.class);
        Items items = mapper.selectByIid(3);
        System.out.println(items.getName() + " " + items.getDetail());
        Items items3 = new Items(5, "手机", "白色塑料制品", 5.3);
        int i=mapper.insertInfo(items3);
        session.commit();
        session.close();
        Items items2 = mapper2.selectByIid(3);
        System.out.println(items2.getName() + " " + items2.getDetail());
        session2.close();

    }
    //测试第三方缓存
    @Test
    public void test3() throws Exception {
        SqlSession session = factory.openSession();
        ItemsMapper mapper = session.getMapper(ItemsMapper.class);

        SqlSession session2 = factory.openSession();
        ItemsMapper mapper2 = session2.getMapper(ItemsMapper.class);

        Items items = mapper.selectByIid(3);
        System.out.println(items.getName() + " " + items.getDetail());
//        Items items3 = new Items(6, "手机", "白色塑料制品", 5.3);
//        int i=mapper.insertInfo(items3);
//        session.commit();
        session.close();

        Items items2 = mapper2.selectByIid(3);
        System.out.println(items2.getName() + " " + items2.getDetail());
        session2.close();

    }
}
