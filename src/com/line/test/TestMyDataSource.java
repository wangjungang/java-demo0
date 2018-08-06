package com.line.test;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class TestMyDataSource {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 1.创建自定义连接池对象
        MyDataSource dataSource = new MyDataSource();
        try {


            // 2.从池子中获取连接
            conn = dataSource.getConnection();


            String s=""+"insert into net_tableinfo(age,name,address) values(?,?,?)";
            pstmt=conn.prepareStatement(s);


            pstmt.setString(1,"29");
            pstmt.setString(2,"网络");
            pstmt.setString(3,"重庆");


            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("添加成功!");
            } else {
                System.out.println("添加失败!");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            dataSource.backConnection(conn);
        }
    }

}
