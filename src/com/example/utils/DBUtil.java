package com.example.utils;

import java.sql.*;

/**
 * EmployeeInformationManagementSystem
 * 数据库连接
 *
 * @author PlutoCtx ctx195467@163.com
 * @version 2024/1/5 16:39
 * @since JDK17
 */

public class DBUtil {
    /**
     数据库
     */
    private String url = "jdbc:mysql://localhost:3306/sys";
    /**
     * 用户名
     */
    private String username = "root";
    /**
     * 密码
     */
    private String password = "Shangxiao111";
    /**
     * 驱动名称
     */
    private String jdbcName = "com.mysql.cj.jdbc.Driver";

    /**
     * 获取数据库连接
     * @return  返回连接
     * @throws Exception 没连上
     */
    public Connection getConnection() throws Exception{
        Class.forName(jdbcName);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


    /**
     * 关闭数据库连接
     * @param connection    数据库连接
     * @throws Exception    异常
     */
    public void closeConnection(Connection connection) throws Exception{
        if (connection != null){
            connection.close();
        }
    }

    public ResultSet getNumberOdBooks(Connection con) throws SQLException {
        String sql = "SELECT * FROM t_book";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }




}
