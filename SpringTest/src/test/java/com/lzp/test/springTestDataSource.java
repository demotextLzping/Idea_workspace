package com.lzp.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public class springTestDataSource {
    @Test
    public void test1() throws SQLException {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContextDataBase.xml");
        DruidDataSource dataSource = (DruidDataSource) appCon.getBean("dataSource");
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
    }


}
