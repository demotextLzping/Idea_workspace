package com.lzp.test;

import com.lzp.mapper.EmpDeptMapper;
import com.lzp.mapper.UsersMapper;
import com.lzp.pojo.EmpDept;
import com.lzp.pojo.Users;
import com.lzp.util.Page;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PseudoColumnUsage;
import java.util.List;

public class MyBatisPage {
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
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        Page page = new Page();
        page.setDataCount(mapper.selectCount());
        page.setShowData(2);//每次展示几个数据
        page.setPageIndex(1);//张氏低级个页面的内容
        page.getPageCount();//获取页面的数量
        page.setList(mapper.selectUserByPage(page));//查询当前页的数据
        session.close();
        List<Users> list = page.getList();
        System.out.println("当前是第"+page.getPageIndex()+" 页，一共有"+page.getPageCount()+" 页");
        for (Users users : list) {
            System.out.println(users.getUid()+" "+users.getUname()+" "+users.getAddress());
        }
    }

    @Test
    public void test2() throws Exception {
        SqlSession session = factory.openSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        //offset表示第几页的索引，limit表示每页取几条数据
        RowBounds rowBounds = new RowBounds(0, 3);
        List<Users> list = mapper.autoUserSelectByPage(rowBounds);
        session.close();
        for (Users users : list) {
            System.out.println(users.getUid()+" "+users.getUname()+" "+users.getAddress());
        }
    }
}
