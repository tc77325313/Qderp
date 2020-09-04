package com.jxqdwh.erp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {

        Statement stat = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tables", "root", "password");
            // con = JDBCUtils.getConnection();
            //new JdbcTemplate((DataSource) JDBCUtils.getConnection());
            String sql = "insert into user  VALUES(null,'tc','123456','user:*','salt')";
            stat = con.createStatement();
            int a = stat.executeUpdate(sql);
            System.out.println(a);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
