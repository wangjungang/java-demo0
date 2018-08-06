package com.line.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class addtTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pres = null;
        MyDataSource datasource = new MyDataSource();

        try {
            conn = datasource.getConnection();
            String s=""+"insert into net_tableinfo(age,name,address,pick) values(?,?,?,?)";
            pres=conn.prepareStatement(s);


            pres.setString(1,"29");
            pres.setString(2,"网络");
            pres.setString(3,"重庆");
            pres.setString(4,"news");

            int rows = pres.executeUpdate();
            if (rows > 0) {
                System.out.println("添加成功!");
            } else {
                System.out.println("添加失败!");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            datasource.backConnection(conn);
        }

    }

}
