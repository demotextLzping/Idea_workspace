package com.test;

import com.lzp.pojo.Dept;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.Alias;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    private SqlSessionFactory factory;
    @Before
    public void before() throws Exception{
        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(resource,"development");

    }
    @Test
    public void test01() throws IOException {
        SqlSession session = factory.openSession();
        List<Dept> list = session.selectList("selectAllDept");
        for (Dept dept : list) {
            System.out.println(dept.getDeptno() + " " + dept.getDname() + " " + dept.getLoc());
        }
        session.close();
    }
    @Test
    public void selectById()throws IOException{
        SqlSession session = factory.openSession();
        Dept dept= (Dept) session.selectOne("selectDeptById",10);
        System.out.println(dept.getDeptno()+"; "+dept.getDname()+"; "+dept.getLoc());
        session.close(); 
    }
    @Test
    public void insertDept() throws IOException{
        SqlSession session = factory.openSession();
        Dept dept=new Dept(50,"tec","hubei");
        int row=session.insert("insertDept",dept);
//        需要手动提交
        session.commit();
        session.close();
        System.out.println(row>0?"添加成功":"添加失败");
    }
    @Test
    public  void insertUseGeneratedKey() throws IOException {
        SqlSession session = factory.openSession();
        Dept dept = new Dept();
        dept.setDname("serve");
        dept.setLoc("shanghai");
        int  row =session.insert("insertUseGeneratedKey",dept);
        session.commit();
        session.close();
        System.out.println(row>0?"添加成功":"添加失败");
    }

    @Test
    public  void updateById() throws IOException {
        SqlSession session = factory.openSession();
        Dept dept = new Dept();
        dept.setDeptno(50);
        dept.setLoc("jingzhou");
        int  row = session.update("updateById", dept);
        session.commit();
        session.close();
        System.out.println(row>0?"修改成功":"修改失败");
    }

    @Test
    public  void deleteById() throws IOException {
        SqlSession session = factory.openSession();
        int  row = session.update("deleteById", 51);
        session.commit();
        session.close();
        System.out.println(row>0?"删除成功":"删除失败");
    }

}
