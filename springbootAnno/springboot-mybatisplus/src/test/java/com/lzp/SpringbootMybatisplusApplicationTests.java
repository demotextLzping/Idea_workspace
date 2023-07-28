package com.lzp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzp.pojo.Dept;
import com.lzp.serice.DeptService;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {
    @Autowired
    private DeptService deptService;


    @Test
    void test() {
        List<Dept> list = deptService.list();
        list.forEach(System.out::println);
    }

    @Test
    void testQueryWrapper() {
//        全部 部门号大于50
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("deptno", 50);
        List<Dept> list = deptService.list(queryWrapper);
        list.forEach(System.out::println);

        System.out.println("===============================");
        //        单个 部门号大于50
        QueryWrapper<Dept> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("deptno", 50);
        Dept one = deptService.getOne(queryWrapper2);
        System.out.println(one);
    }

    @Test
    void testAdd() {
        boolean save = deptService.save(new Dept(null, "info", "uk"));
        System.out.println(save);
    }

    @Test
    void testUpdate() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno", 61);
        Dept dept = new Dept();
        dept.setDname("xxx");
        dept.setLoc("yyy");
        boolean update = deptService.update(dept, queryWrapper);
        System.out.println(update);
        Dept one = deptService.getOne(queryWrapper);
        System.out.println(one);
    }

    @Test
    void testDel() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno", 61);
        boolean remove = deptService.remove(queryWrapper);
        System.out.println(remove);
    }

    //测试分页
    @Test
    void testPage() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        Page<Dept> page = deptService.page(new Page<>(1, 2), queryWrapper);
        List<Dept> list= page.getRecords();
        list.forEach(System.out::println);
        System.out.println("总页数"+page.getPages());
        System.out.println("总记录数"+page.getTotal());
        System.out.println("当前页"+page.getCurrent());
        System.out.println("页大小"+page.getSize());
    }

}
