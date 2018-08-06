package com.dao.test;

import com.line.test.MyDataSource;
import com.line.test.JDBCUtils3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Savepoint;


public class AccountDao {

    private static MyDataSource dbUtil = new MyDataSource();


    /**
     * 借出钱给他人方
     * @param money
     * @return
     * @throws Exception
     */
    private static int OutMoney(Account money)throws Exception{
        Connection conn = dbUtil.getConnection();
        String sql = "update t_money set money=money-? where id = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, money.getMoney());
        pstmt.setInt(2, money.getId());
        int result = pstmt.executeUpdate();
        //dbUtil.close(pstmt, conn);
        return result;
    }

    /**
     * 借到钱的一方
     * @param money
     * @return
     * @throws Exception
     */
    private static int InMoney(Account money)throws Exception{
        Connection conn = dbUtil.getConnection();
        String sql = "update t_money set money=money+? where id = ? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, money.getMoney());
        pstmt.setInt(2, money.getId());
        int result = pstmt.executeUpdate();
        //dbUtil.close(pstmt, conn);
        return result;
    }


    public static void main(String[] args) {
        int moneys = 10;
        Account Age = new Account(1, moneys);
        Account Bge = new Account(2, moneys);
        Connection conn1 = null;
        Savepoint  sp = null;
        try {
            conn1 = dbUtil.getConnection();
            //取消自动提交事务
            conn1.setAutoCommit(false);
            //设置事务保存点,如果发生错误则回滚到此处
            sp = conn1.setSavepoint();
            //Age借出钱给Bge
            OutMoney(Age);
            System.out.println("Age借钱成功!");
            //Bge收到钱
            InMoney(Bge);
            System.out.println("Bge收到钱成功!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            try {
                //如果遇到错误就回滚
                conn1.rollback(sp);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println("Age借钱失败!");
            System.out.println("Bge收到钱失败!");
            e.printStackTrace();
        }finally{
            try {
                //如果事务操作成功，提交事务
                conn1.commit();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                //关闭连接
                conn1.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("钱财交易成功!");
    }


}
