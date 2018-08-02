package com.dgd.test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
增加数据
 */

public class addTest {

    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost/New_info?useSSL=FALSE&serverTimezone=UTC";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {

        Class.forName(DRIVER_NAME);
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        String s=""+"insert into net_tableinfo(age,name,address) values('12','lilei','beijin')";
        PreparedStatement pst=conn.prepareStatement(s);

        //pst.setString(1, "xiaoshuai1");
        //pst.setString(2, "123");

        pst.execute();
        //关闭资源
        pst.close();
        conn.close();
    }

}
