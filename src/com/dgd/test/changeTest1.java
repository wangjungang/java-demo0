package com.dgd.test;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class changeTest1 {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost/New_info?useSSL=FALSE&serverTimezone=UTC";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "password";
    public static void main(String[] args) throws ClassNotFoundException, SQLException  {

        //1.加载驱动程序
        Class.forName(DRIVER_NAME);
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        String s="update net_tableinfo set name=? where id=1 ";
        PreparedStatement pst=conn.prepareStatement(s);

        pst.setString(1, "xiaoshuaige");
        //pst.setString(2, "123");

        pst.execute();
        //关闭资源
        pst.close();
        conn.close();
    }
}
