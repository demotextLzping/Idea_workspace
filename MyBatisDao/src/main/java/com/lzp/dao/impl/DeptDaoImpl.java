package com.lzp.dao.impl;

import com.lzp.dao.DeptDao;
import com.lzp.pojo.Dept;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DeptDaoImpl implements DeptDao {
    private SqlSessionFactory factory;

    public DeptDaoImpl(SqlSessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public List<Dept> selectAll() throws Exception {
        List<Dept> list = null;
        SqlSession session = factory.openSession();
        list = session.selectList("selectAllDept");
        session.close();
        return list;
    }


    @Override
    public Dept selectById(int deptno) throws Exception {
        Dept dept = null;
        SqlSession session = factory.openSession();
        dept = session.selectOne("selectById", deptno);
        return dept;
    }

    @Override
    public int insertDept(Dept dept) throws Exception {
        SqlSession session = factory.openSession();
        int row = session.insert("insertDept", dept);
        session.commit();
        session.close();
        return row;
    }

    @Override
    public int updateDept(Dept dept) throws Exception {
        SqlSession session = factory.openSession();
        int row = session.update("updateDept", dept);
        session.commit();
        session.close();
        return row;
    }

    @Override
    public int deleteDept(int deptno) throws Exception {
        SqlSession session = factory.openSession();
        int row = session.delete("deleteDept", deptno);
        session.commit();
        session.close();
        return row;
    }

}
