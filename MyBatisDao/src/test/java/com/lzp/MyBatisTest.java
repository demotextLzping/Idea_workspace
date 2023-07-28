package com.lzp;

import com.lzp.dao.impl.DeptDaoImpl;
import com.lzp.pojo.Dept;
import org.apache.ibatis.io.Resources;
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
    public void selectAll() throws Exception {
        DeptDaoImpl deptDaoImpl = new DeptDaoImpl(factory);
        List<Dept> list = deptDaoImpl.selectAll();
        for (Dept dept : list) {
            System.out.println(dept.getDeptno() + " " + dept.getDname() + " " + dept.getLoc());
        }

    }

    @Test
    public void selectById() throws Exception {
        DeptDaoImpl deptDaoImpl = new DeptDaoImpl(factory);
        int deptno = 10;
        Dept dept = deptDaoImpl.selectById(deptno);
        System.out.println(dept.getDeptno() + " " + dept.getDname() + " " + dept.getLoc());

    }

    @Test
    public void insertDept() throws Exception {
        DeptDaoImpl deptDaoImpl = new DeptDaoImpl(factory);
        Dept dept = new Dept(60, "teach", "suzhou");
        int row = deptDaoImpl.insertDept(dept);
        System.out.println(row == 1 ? "添加成功" : "添加失败");
    }

    @Test
    public void updateDept() throws Exception {
        DeptDaoImpl deptDaoImpl = new DeptDaoImpl(factory);
        Dept dept = new Dept();
        dept.setDeptno(60);
        dept.setDname("link");
        dept.setLoc("guizhou");
        int row = deptDaoImpl.updateDept(dept);
        System.out.println(row == 1 ? "修改成功" : "修改失败");
    }

    @Test
    public void deleteDept() throws Exception {
        DeptDaoImpl deptDaoImpl = new DeptDaoImpl(factory);
        int deptno = 60;
        int row = deptDaoImpl.deleteDept(deptno);
        System.out.println(row == 1 ? "删除成功" : "删除失败");
    }
}
