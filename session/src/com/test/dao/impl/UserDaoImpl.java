package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/mytestdb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&&serverTimezone=Asia/Shanghai&useServerPrepStmts=true&cachePrepStmts=true";
    private static String sqlLoginName = "root";
    private static String sqlLoginPassword = "123456";

    @Override
    public User checkUser(User user) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User checkUser = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, sqlLoginName, sqlLoginPassword);
            String sql = "select * from user where name=? and pwd=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPwd());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                checkUser = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("pwd"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return checkUser;
    }
}
