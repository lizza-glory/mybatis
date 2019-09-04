package com.lizza.base_01.build_config.service;

import java.sql.*;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-09-04
 */
public class JDBC {

    public static void main(String[] args){
        String driverClass = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://106.13.87.102:3306/learner";
        String username = "root";
        String password = "lizza@123";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);
            String sql = "select * from student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("student_name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
